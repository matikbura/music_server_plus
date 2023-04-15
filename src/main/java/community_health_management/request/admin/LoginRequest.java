package community_health_management.request.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理员登录请求")
@Data
public class LoginRequest {
    @Schema(description = "用户名")
    @NotNull(message = "用户名不能为空")
    private String account;
    @Schema(description = "密码")
    @NotNull(message = "密码不能为空")
    private String password;
}
