package com.lj.music_server_plus.controller.user;

import com.lj.music_server_plus.body.user.PageQueryBody;
import com.lj.music_server_plus.body.user.comment.CommentAddBody;
import com.lj.music_server_plus.body.user.comment.CommentQueryBody;
import com.lj.music_server_plus.common.result.Result;
import com.lj.music_server_plus.common.ustils.BaseUtil;
import com.lj.music_server_plus.entity.Comment;
import com.lj.music_server_plus.enums.Type;
import com.lj.music_server_plus.service.*;
import com.lj.music_server_plus.vo.PageResult;
import com.lj.music_server_plus.vo.comment.CommentVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Collection", description = "评论模块")
@RestController
@RequestMapping("comment")
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;
    private final MusicService musicService;
    private final PlaylistService playlistService;
    private final AlbumService albumService;
    private final SingerService singerService;
    private final MvService mvService;
    public CommentController(CommentService commentService, UserService userService, MusicService musicService, PlaylistService playlistService, AlbumService albumService, SingerService singerService, MvService mvService) {
        this.commentService = commentService;
        this.userService = userService;
        this.musicService = musicService;
        this.playlistService = playlistService;
        this.albumService = albumService;
        this.singerService = singerService;
        this.mvService = mvService;
    }

    @Operation(summary = "添加评论")
    @PostMapping("addComment")
    public Result<Comment> addComment(@RequestBody @Validated CommentAddBody commentAddBody, HttpServletRequest request){
        commentAddBody.setUserId(BaseUtil.getLoginId(request,true));
        Comment comment = commentService.addComment(commentAddBody);
        if (comment.getType()== Type.MUSIC.getTypeNum()){
            musicService.addCommentCount(comment.getTypeId());
        }else if (comment.getType()== Type.PLAYLIST.getTypeNum()){
            playlistService.addCommentCount(comment.getTypeId());
        }else if (comment.getType()== Type.ALBUM.getTypeNum()){
            albumService.addCommentCount(comment.getTypeId());
        }else if (comment.getType()== Type.SINGER.getTypeNum()){
            singerService.addCommentCount(comment.getTypeId());
        }else if (comment.getType()== Type.MV.getTypeNum()){
            mvService.addCommentCount(comment.getTypeId());
        }
        return Result.success(comment);
    }
    @Operation(summary = "获取评论并分页")
    @PostMapping("getCommentListPage")
    public Result<PageResult<CommentVo>> getCommentListPage(@RequestBody @Validated PageQueryBody<CommentQueryBody> commentAddBody){
        PageResult<CommentVo> commentListPage = commentService.getCommentListPage(commentAddBody);
        for (CommentVo commentVo : commentListPage.getData()) {
            commentVo.setUser(userService.getUserById(commentVo.getUserId()));
            if (commentVo.getTargetId() != null) {
                commentVo.setTargetUser(userService.getUserById(commentVo.getTargetId()));
            }
        }
        return Result.success(commentListPage);
    }
}
