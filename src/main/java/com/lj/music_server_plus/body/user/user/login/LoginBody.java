package com.lj.music_server_plus.body.user.user.login;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "登录请求参数")
@Data
public class LoginBody {

    @Schema(description = "账号" ,requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "账号不能为空")
    private String username;
    @Schema(description = "密码" ,requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "密码不能为空")
    private String password;
    @Schema(hidden = true)
    private Integer role;
}
