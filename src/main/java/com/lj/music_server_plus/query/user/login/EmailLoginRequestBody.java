package com.lj.music_server_plus.query.user.login;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "邮箱登录请求参数")
@Data
public class EmailLoginRequestBody {
    @Schema(description = "邮箱",requiredMode = Schema.RequiredMode.REQUIRED)
    @Email(message = "邮箱格式不正确")
    private String email;
    @Schema(description = "验证码",requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "验证码不能为空")
    private String checkCode;

}
