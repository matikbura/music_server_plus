package community_health_management.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "登录请求")
@Data
public class LoginRequest {
    @Schema(description = "账号")
    @NotEmpty(message = "账号不能为空")
    private String account;
    @Schema(description = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
