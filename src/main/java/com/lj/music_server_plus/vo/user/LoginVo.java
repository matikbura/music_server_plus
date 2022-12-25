package com.lj.music_server_plus.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "LoginVo",description = "登录后返回的信息")
@Data
public class LoginVo {
    @Schema(name = "id",description = "id")
    private Integer id;
    @Schema(name = "username",description = "用户名")
    private String username;
    @Schema(name = "avatar",description = "用户头像路径")
    private String avatar;
    @Schema(name = "nickname",description = "用户名称")
    private String nickname;
    @Schema(name = "roleText",description = "角色名称")
    private String roleText;
    @Schema(name = "token",description = "唯一token")
    private String token;
}
