package community_health_management.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(name = "AddUserRequest", description = "添加用户")
public class AddUserRequest {

    /**
     * 账号
     */
    @Schema(description = "账号")
    @NotEmpty(message = "账号不能为空")
    private String account;

    /**
     * 密码
     */
    @Schema(description = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
    /**
     * 角色
     */
    @Schema(description = "角色")
    @NotNull(message = "角色不能为空")
    private Integer role;

    /**
     * 名称
     */
    @Schema(description = "名称")
    private String nickname;

    /**
     * 手机号
     */
    @Schema(description = "手机号")
    private String phone;

    /**
     * 性别
     */
    @Schema(description = "性别")
    private Integer gender;

    /**
     * 员工编号
     */
    @Schema(description = "员工编号")
    private String wNo;

    /**
     * 年龄
     */
    @Schema(description = "年龄")
    private Integer age;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * QQ
     */
    @Schema(description = "QQ")
    private String qq;

    /**
     * 微信
     */
    @Schema(description = "微信")
    private String wechat;



}
