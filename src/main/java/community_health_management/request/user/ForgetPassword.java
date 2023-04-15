package community_health_management.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "忘记密码请求体")
public class ForgetPassword {
    @Schema(description = "邮箱")
    private String email;
    @Schema(description = "新密码")
    private String password;
    @Schema(description = "验证码")
    private String code;
}
