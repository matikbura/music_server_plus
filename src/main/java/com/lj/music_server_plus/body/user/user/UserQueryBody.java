package com.lj.music_server_plus.body.user.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户条件查询请求参数")
public class UserQueryBody {
    @Schema(name = "username",description = "用户名")
    private String username;
    @Schema(name = "email",description = "邮箱")
    private String email;
    @Schema(name = "phone",description = "手机号")
    private String phone;
    @Schema(name = "status",description = "状态")
    private Integer status;
    @Schema(name="sex",description = "性别")
    private String sex;
}
