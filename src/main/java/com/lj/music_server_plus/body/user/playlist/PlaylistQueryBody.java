package com.lj.music_server_plus.body.user.playlist;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "查询歌单请求体")
@Data
public class PlaylistQueryBody {
    @Schema(name = "name",description = "歌单名称")
    private String name;
    @Schema(name = "description",description = "描述")
    private String description;
    @Schema(name = "userId",description = "创建者id")
    private Integer userId;
    @Schema(name = "tagId",description = "标签id")
    private Integer tagId;
    @Schema(name = "sortField",description = "排序字段")
    private List<String> sortFields;
}
