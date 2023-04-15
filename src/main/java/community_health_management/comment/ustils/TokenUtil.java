package community_health_management.comment.ustils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import community_health_management.enums.Role;
import community_health_management.exception.AuthException;
import community_health_management.vo.AdminVo;
import community_health_management.vo.UserVo;
import jakarta.servlet.http.HttpServletResponse;


public class TokenUtil {
    //获取token
    public static String getToken(AdminVo adminVo) {
        return JWT.create().setNotBefore(DateUtil.date())
                .setExpiresAt(DateUtil.offsetMinute(DateUtil.date(), 30))
                .setPayload("username", adminVo.getAccount())
                //管理员直接设置为0
                .setPayload("role", Role.ADMIN.getCode())
                .setPayload("id", adminVo.getAid())
                .setKey("123456".getBytes())
                .sign();
    }
    public static String getToken(UserVo userVo) {
        return JWT.create().setNotBefore(DateUtil.date())
                .setExpiresAt(DateUtil.offsetMinute(DateUtil.date(), 30))
                .setPayload("username", userVo.getAccount())
                //管理员直接设置为0
                .setPayload("role", userVo.getRole())
                .setPayload("id", userVo.getUid())
                .setKey("123456".getBytes())
                .sign();
    }

    //验证token
    public static void verify(String token, Integer type, HttpServletResponse response) {
        if (token == null|| "".equals(token)) {
            throw new AuthException("您还未登录");
        }
        //验证是否已过期
        JWT.of(token).setKey("123456".getBytes()).validate(0);
        //如果类型为管理员 验证token中的role是否为管理员

        if (type!=null&&type!=-1) {
            Integer role;
            try {
                JWT jwt = JWTUtil.parseToken(token);
                role = (Integer) jwt.getPayload("role");
            } catch (Exception e) {
                throw new AuthException("token无效，请重新登录");
            }

            if(!role.equals(type)){
                throw new AuthException("您没有权限访问");
            }
        }
        //如果失效时间小于5分钟，生效时间加30分钟
        if ((Integer) JWT.of(token).setKey("123456".getBytes()).getPayload(JWTPayload.EXPIRES_AT) - DateUtil.currentSeconds() < 300) {
            JWT jwt = JWT.of(token).setKey("123456".getBytes());
            jwt.setPayload("exp", DateUtil.currentSeconds() + 1800);
            String newToken = jwt.sign();
            response.setHeader("Authorization", newToken);
        }
    }

    //获取token中的userId
    public static Integer getId(String token) {
        Integer userId=null;
        try {
            JWT jwt = JWTUtil.parseToken(token);
             userId = (Integer) jwt.getPayload("id");
        }catch (Exception e){
            throw new AuthException("您还未登录");
        }
        if (userId == null) {
            throw new AuthException("获取id失败");
        }
        return userId;
    }

    //获取token中的role
    public static Integer getRole(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        Integer role = (Integer) jwt.getPayload("role");
        if (role == null) {
            throw new AuthException("获取用户角色失败");
        }
        return role;
    }
}
