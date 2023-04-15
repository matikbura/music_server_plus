package community_health_management.vo;

import lombok.Data;

import java.util.Date;
@Data
public class AdminVo {
    /**
     * 管理员id
     */
    private Integer aid;

    /**
     * 账号
     */
    private String account;


    /**
     * 邮箱
     */
    private String email;

    /**
     * QQ
     */
    private String qq;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private String token;
}
