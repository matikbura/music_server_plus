package com.lj.music_server_plus.controller.admin;

import com.lj.music_server_plus.common.result.Result;
import com.lj.music_server_plus.vo.user.LoginVo;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
@Tag(name = "Admin", description = "管理员模块")
public class AdminController {
    @PostMapping("login")
    @Schema(description = "登录")
    public Result<LoginVo> login() {
        return Result.success(null);
    }
}
