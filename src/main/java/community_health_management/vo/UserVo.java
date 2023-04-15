package community_health_management.vo;

import community_health_management.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "UserVo", description = "用户")
public class UserVo extends User {
    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Integer uid;

    /**
     * 账号
     */
    @Schema(description = "账号")
    private String account;


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

    /**
     * 角色
     */
    @Schema(description = "角色")
    private Integer role;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    private Date updateTime;
}
