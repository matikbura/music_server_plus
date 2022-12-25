package com.lj.music_server_plus.service;

import com.lj.music_server_plus.query.user.login.LoginRequestBody;
import com.lj.music_server_plus.vo.user.LoginVo;

public interface UserService {
    LoginVo login(LoginRequestBody loginBody);
}
