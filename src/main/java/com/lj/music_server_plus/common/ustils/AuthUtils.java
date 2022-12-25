package com.lj.music_server_plus.common.ustils;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.lj.music_server_plus.exception.AuthException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class AuthUtils {
    //用户名
    private final String USERNAME_Field = "username";
    //用户角色
    private final String USER_ROLE_Field = "userRole";
    private final StringRedisTemplate redisTemplate;
    public AuthUtils(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    //默认生效时间 生效时间应比过期时间长30分钟 以防止过期时间到了 但是还没来得及刷新token
    //刷新时间的最大阈值 30分钟
    private final long FLUSH_TIME = 30;
    private final long DEFAULT_EXPIRE_TIME = 60*2+FLUSH_TIME;


    public String getToken(String username, String userRole){
        //生成token
        String token = IdUtil.simpleUUID();
        //创建时间
        long createTime = System.currentTimeMillis();
        //创建json对象
        JSONObject jsonObject = JSONUtil.createObj();
        jsonObject.set(USERNAME_Field,username);
        jsonObject.set(USER_ROLE_Field,userRole);
        //存入redis
        redisTemplate.opsForValue().set(token,jsonObject.toString(),DEFAULT_EXPIRE_TIME, TimeUnit.SECONDS);
        return token;
    }
    public String verifyFlowFlush (String token){
        //key是否存在
        if (Boolean.TRUE.equals(redisTemplate.hasKey(token))){
            //获取token的值
            String tokenValue = redisTemplate.opsForValue().get(token);
            //转换为json对象
            JSONObject jsonObject = JSONUtil.parseObj(tokenValue);
            //获取创建时间
            long createTime = jsonObject.getLong("createTime");
            //获取当前时间
            long currentTime = System.currentTimeMillis();
            //判断是否需要刷新
            if (currentTime-createTime>DEFAULT_EXPIRE_TIME*1000-FLUSH_TIME*60*1000){
                //刷新token
                String username = jsonObject.getStr(USERNAME_Field);
                String userRole = jsonObject.getStr(USER_ROLE_Field);
                //删除旧token
                redisTemplate.delete(token);
                //创建新token
                String newToken = getToken(username,userRole);
                return newToken;
            }
        }else{
            //token不存在
            throw new AuthException("token不存在");
        }
        return null;
    }


    //判断key是否存在
    private boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }
    //获取key的value值并转化为JSONObject类型
    private JSONObject getValueJSONObj(String key) {
        String value = redisTemplate.opsForValue().get(key);
        return JSONUtil.parseObj(value);
    }
    //生成token
    private String generateToken(JSONObject jsonObject) {
        //生成32位的UUID
        String token = UUID.randomUUID().toString().replace("-", "");
        //将token存入redis 设置生效时间
        redisTemplate.opsForValue().set(token, jsonObject.toString(), DEFAULT_EXPIRE_TIME, TimeUnit.MINUTES);
        return token;
    }
    //刷新token
    private String refreshToken(String token) {
        //获取token的value值
        JSONObject jsonObject = getValueJSONObj(token);
        //刷新token
        String newToken = generateToken(jsonObject);
        //删除旧token
        redisTemplate.delete(token);
        return newToken;
    }

}
