package com.lj.music_server_plus.vo.comment;

import com.lj.music_server_plus.entity.Comment;
import com.lj.music_server_plus.vo.user.UserLess;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "CommentVo", description = "评论-信息")
public class CommentVo {
    private Integer id;

    private Integer userId;

    private Integer targetId;

    private Integer typeId;

    private String content;

    private Integer type;

    private String createTime;

    private Integer targetCommentId;
    private UserLess user;
    private UserLess targetUser;
    private Comment targetComment;
}
