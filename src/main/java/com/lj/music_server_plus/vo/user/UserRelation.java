package com.lj.music_server_plus.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "用户个人信息")
public class UserRelation {
    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 地址
     */
    private String address;

    /**
     * 微信
     */
    private String vx;

}
