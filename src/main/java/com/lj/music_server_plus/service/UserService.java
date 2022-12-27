package com.lj.music_server_plus.service;

import com.lj.music_server_plus.body.user.user.login.LoginBody;
import com.lj.music_server_plus.vo.user.LoginVo;
import com.lj.music_server_plus.vo.user.UserLess;

public interface UserService {
    LoginVo login(LoginBody loginBody);

    UserLess getUserById(Integer userId);
}
