package com.lj.music_server_plus.body.user.playlist;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "添加歌单请求体")
@Data
public class PlaylistAddBody {
    @Schema(name = "name", description = "歌单名称")
    @NotEmpty(message = "歌单名称不能为空")
    private String name;
    @Schema(hidden = true)
    private Integer userId;
    @Schema(name="createTime",description = "创建时间")
    @NotEmpty(message = "创建时间不能为空")
    private String createTime;
    @Schema(name = "modifiedTime", description = "修改时间")
    @NotEmpty(message = "修改时间不能为空")
    private String modifiedTime;
}
