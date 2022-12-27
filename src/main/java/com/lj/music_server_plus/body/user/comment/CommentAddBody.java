package com.lj.music_server_plus.body.user.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(name = "CommentAddBody", description = "评论-添加请求体")
@Data
public class CommentAddBody {
    @Schema(hidden = true)
    private Integer userId;

    @Schema(description = "被评论的目标用户id")
    private Integer targetId;

    @Schema(description = "评论的类型目标id")
    @NotNull(message = "评论的类型目标id不能为空")
    private Integer typeId;

    @Schema(description = "评论内容")
    @NotEmpty(message = "评论内容不能为空")
    private String content;
    @Schema(description = "评论类型：1-歌曲，2-歌单，3-专辑，4-歌手，5-用户")
    @NotNull(message = "评论类型不能为空")
    private Integer type;
    @Schema(description = "创建时间")
    @NotEmpty(message = "创建时间不能为空")
    private String createTime;
    @Schema(description = "被评论的目标评论id")
    private Integer targetCommentId;
}
