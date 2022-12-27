package com.lj.music_server_plus.service.impl;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lj.music_server_plus.body.user.PageQueryBody;
import com.lj.music_server_plus.body.user.comment.CommentAddBody;
import com.lj.music_server_plus.body.user.comment.CommentQueryBody;
import com.lj.music_server_plus.common.ustils.BaseUtil;
import com.lj.music_server_plus.entity.Comment;
import com.lj.music_server_plus.mapper.CommentMapper;
import com.lj.music_server_plus.service.CommentService;
import com.lj.music_server_plus.vo.PageResult;
import com.lj.music_server_plus.vo.comment.CommentVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public Comment addComment(CommentAddBody commentAddBody) {
        Comment convert = Convert.convert(Comment.class, commentAddBody);
        commentMapper.insert(convert);
        return convert;
    }

    @Override
    public PageResult<CommentVo> getCommentListPage(PageQueryBody<CommentQueryBody> commentAddBody) {
        PageHelper.startPage(commentAddBody.getPageCurrent(), commentAddBody.getPageSize());
        List<Comment> byAll = commentMapper.findByAll(Convert.convert(Comment.class, commentAddBody.getCondition()));
        PageInfo<Comment> pageInfo = new PageInfo<>(byAll);
        PageResult<CommentVo> pageResult = new PageResult<>();
        pageResult.setHasNext(pageInfo.isHasNextPage());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setData(BaseUtil.convertList(byAll, CommentVo.class));
        for (CommentVo commentVo : pageResult.getData()) {
            if(commentVo.getTargetCommentId()!=null){
                Comment comment = commentMapper.selectByPrimaryKey(commentVo.getTargetCommentId());
                commentVo.setTargetComment(comment);
            }
        }
        return pageResult;
    }
}
