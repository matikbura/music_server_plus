package com.lj.music_server_plus.service;

import com.lj.music_server_plus.body.user.PageQueryBody;
import com.lj.music_server_plus.body.user.comment.CommentAddBody;
import com.lj.music_server_plus.body.user.comment.CommentQueryBody;
import com.lj.music_server_plus.entity.Comment;
import com.lj.music_server_plus.vo.PageResult;
import com.lj.music_server_plus.vo.comment.CommentVo;

public interface CommentService {
    Comment addComment(CommentAddBody commentAddBody);

    PageResult<CommentVo> getCommentListPage(PageQueryBody<CommentQueryBody> commentAddBody);

}
