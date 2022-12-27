package com.lj.music_server_plus.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import com.lj.music_server_plus.body.user.user.login.LoginBody;
import com.lj.music_server_plus.entity.User;
import com.lj.music_server_plus.enums.Role;
import com.lj.music_server_plus.exception.AuthException;
import com.lj.music_server_plus.mapper.UserMapper;
import com.lj.music_server_plus.service.UserService;
import com.lj.music_server_plus.vo.user.LoginVo;
import com.lj.music_server_plus.vo.user.UserLess;
import jakarta.xml.bind.ValidationException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public LoginVo login(LoginBody loginBody) {
        //转换为实体类
        User convert = Convert.convert(User.class, loginBody);
        //查询
        User user= userMapper.login(convert);
        if (user == null) {
            throw new AuthException("用户名或密码错误");
        }else{
            LoginVo result = Convert.convert(LoginVo.class, user);
            //role
            result.setRoleText(Role.getText(user.getRole()));
            result.setToken(getToken(result));
            return result;
        }
    }

    @Override
    public UserLess getUserById(Integer userId) {
        return Convert.convert(UserLess.class, userMapper.selectByPrimaryKey(userId));
    }

    private String getToken(LoginVo loginVo) {
        return JWT.create().setNotBefore(DateUtil.date())
                .setExpiresAt(DateUtil.offsetMinute(DateUtil.date(), 30))
                .setPayload("username", loginVo.getUsername())
                .setPayload("roleText", loginVo.getRoleText())
                .setKey("123456".getBytes())
                .sign();
    }
}
