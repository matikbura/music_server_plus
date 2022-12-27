package com.lj.music_server_plus.controller.user;

import cn.hutool.core.convert.Convert;
import com.lj.music_server_plus.body.user.PageQueryBody;
import com.lj.music_server_plus.body.user.playlist.PlaylistAddBody;
import com.lj.music_server_plus.body.user.playlist.PlaylistQueryBody;
import com.lj.music_server_plus.common.result.Result;
import com.lj.music_server_plus.common.ustils.BaseUtil;
import com.lj.music_server_plus.entity.Playlist;
import com.lj.music_server_plus.enums.Type;
import com.lj.music_server_plus.exception.AuthException;
import com.lj.music_server_plus.service.CollectionService;
import com.lj.music_server_plus.service.PlaylistService;
import com.lj.music_server_plus.service.UserService;
import com.lj.music_server_plus.vo.PageResult;
import com.lj.music_server_plus.vo.playlist.PlaylistBaseWithUserVo;
import com.lj.music_server_plus.vo.playlist.PlaylistLessVo;
import com.lj.music_server_plus.vo.playlist.PlaylistTypeVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Tag(name = "PlaylistController", description = "歌单模块")
@RestController
@RequestMapping("/playlist")
public class PlaylistController {
    private final PlaylistService playlistService;
    private final CollectionService collectionService;
    private final UserService userService;

    public PlaylistController(PlaylistService playlistService, CollectionService collectionService, UserService userService) {
        this.playlistService = playlistService;
        this.collectionService = collectionService;
        this.userService = userService;
    }

    @Operation(summary = "分页获取歌单列表")
    @PostMapping("getPlaylistListAndPage")
    public Result<PageResult<PlaylistBaseWithUserVo>> getPlaylistListAndPage(@RequestBody @Validated PageQueryBody<PlaylistQueryBody> pageQueryBody) {
        PageResult<PlaylistBaseWithUserVo> playlistBaseWithUserVos = playlistService.getPlaylistListAndPage(pageQueryBody.getPageCurrent(), pageQueryBody.getPageSize(), pageQueryBody.getCondition());
        return Result.success(playlistBaseWithUserVos);
    }
    @Operation(summary = "获取歌单详情")
    @GetMapping("getPlayListDetail")
    public Result<PlaylistBaseWithUserVo> getPlayListDetail(@RequestParam @Validated @NotNull(message = "id不可为空") Integer id, HttpServletRequest request) {
        Integer loginId = BaseUtil.getLoginId(request,false);
        //获取歌单详情
        Playlist playlistBaseWithUserVo = playlistService.getPlayListDetail(id);
        //类型转换
        PlaylistBaseWithUserVo convert = Convert.convert(PlaylistBaseWithUserVo.class, playlistBaseWithUserVo);
        //获取歌单创建者信息
        Optional.ofNullable(userService.getUserById(playlistBaseWithUserVo.getUserId())).ifPresent(convert::setUser);
        //如果已经登录需要查看是否登录
        Optional.ofNullable(loginId).ifPresent(integer -> {
            convert.setIsCollected(collectionService.isCollected(loginId, id,Type.PLAYLIST.getTypeNum()));
        });
        return Result.success(convert);
    }
    @Operation(summary = "获取歌单风格列表")
    @GetMapping("getPlaylistStyleList")
    public Result<List<PlaylistTypeVo>> getPlaylistStyleList() {
        return Result.success(playlistService.getPlaylistStyleList());
    }
    @Operation(summary = "获取登录者的歌单")
    @GetMapping("getPlaylistMoodList")
    public Result<List<PlaylistLessVo>>
    getPlaylistMoodList(HttpServletRequest request) {
        //如果不为空则转换为Integer 否则抛出异常
        Integer loginId =  BaseUtil.getLoginId(request,true);
        return Result.success(playlistService.getPlaylistMoodList(loginId));
    }
    @Operation(summary = "添加歌单")
    @PostMapping("addPlaylist")
    public Result<PlaylistLessVo> addPlaylist(@RequestBody @Validated PlaylistAddBody playlistAddBody, HttpServletRequest request) {
        //如果不为空则转换为Integer 否则抛出异常
        Integer loginId = BaseUtil.getLoginId(request,true);
        playlistAddBody.setUserId(loginId);
        return Result.success(playlistService.addPlaylist(playlistAddBody));
    }
}
