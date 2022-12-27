package com.lj.music_server_plus.body.user.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Schema(name = "CommentQueryBody", description = "评论-查询请求体")
public class CommentQueryBody {
    @Schema(name = "sortFields", description = "排序字段")
    @NotNull(message = "排序字段不能为空")
    private List<String> sortFields;
    @Schema(name = "type", description = "评论类型：1-歌曲，2-歌单，3-专辑，4-歌手，5-用户")
    @NotNull(message = "评论类型不能为空")
    private Integer type;
    @Schema(name = "typeId", description = "评论的类型目标id")
    @NotNull(message = "评论的类型目标id不能为空")
    private Integer typeId;
}
