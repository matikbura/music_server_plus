package com.lj.music_server_plus.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(name = "UserLess",description = "用户接口-用户基本信息")
@Data
public class UserLess {
    @Schema(name = "id",description = "id")
    private Integer id;
    @Schema(name = "avatar",description = "用户头像路径")
    private String avatar;
    @Schema(name = "nickname",description = "用户名称")
    private String nickname;
    @Schema(name = "isRelationPublic",description = "联系方式是否公开")
    private Boolean isRelationPublic;
}
