package com.lj.music_server_plus.controller.user;

import com.lj.music_server_plus.common.result.Result;
import com.lj.music_server_plus.query.user.login.LoginRequestBody;
import com.lj.music_server_plus.service.UserService;
import com.lj.music_server_plus.vo.user.LoginVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="User",description = "用户模块")
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    @Operation(summary = "登录")
    public Result<LoginVo> login(@RequestBody @Validated LoginRequestBody loginBody) {
        loginBody.setRole(0);
        return Result.success(userService.login(loginBody));
    }
}
