package com.lj.music_server_plus.controller.user;

import com.lj.music_server_plus.body.user.collection.CollectionAddBody;
import com.lj.music_server_plus.body.user.collection.CollectionRemoveBody;
import com.lj.music_server_plus.common.result.Result;
import com.lj.music_server_plus.entity.MyCollection;
import com.lj.music_server_plus.enums.Type;
import com.lj.music_server_plus.exception.AuthException;
import com.lj.music_server_plus.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("collection")
@Tag(name = "Collection", description = "收藏模块")
public class CollectionController {
    private final CollectionService collectionService;
    private final MusicService musicService;
    private final PlaylistService playlistService;
    private final AlbumService albumService;
    private final SingerService singerService;
    private final MvService mvService;

    public CollectionController(CollectionService collectionService, MusicService musicService, PlaylistService playlistService, AlbumService albumService, SingerService singerService, MvService mvService) {
        this.collectionService = collectionService;
        this.musicService = musicService;
        this.playlistService = playlistService;
        this.albumService = albumService;
        this.singerService = singerService;
        this.mvService = mvService;
    }

    @Operation(summary = "收藏")
    @PostMapping("collect")
    public Result<MyCollection> collect(@RequestBody @Validated CollectionAddBody collectionAddBody, HttpServletRequest request) {
        Integer loginId = Optional.ofNullable(request.getHeader("loginId")).map(Integer::valueOf).orElseThrow(() -> new AuthException("请先登录"));
        collectionAddBody.setUserId(loginId);
        MyCollection collect = collectionService.collect(collectionAddBody);
        if(collect.getType() == Type.MUSIC.getTypeNum()){
            musicService.addCollectionCount(collect.getTypeId());
        }else if(collect.getType() == Type.PLAYLIST.getTypeNum()){
            playlistService.addCollectionCount(collect.getTypeId());
        }else if(collect.getType() == Type.ALBUM.getTypeNum()){
            albumService.addCollectionCount(collect.getTypeId());
        }else if(collect.getType() == Type.SINGER.getTypeNum()){
            singerService.addCollectionCount(collect.getTypeId());
        }else if(collect.getType() == Type.MV.getTypeNum()){
            mvService.addCollectionCount(collect.getTypeId());
        }
        return Result.success(collect);
    }
    @Operation(summary = "取消收藏")
    @PostMapping("cancelCollect")
    public Result<Void> cancelCollect(@RequestBody @Validated CollectionRemoveBody collectionAddBody, HttpServletRequest request) {
        Integer loginId = Optional.ofNullable(request.getHeader("loginId")).map(Integer::valueOf).orElseThrow(() -> new AuthException("请先登录"));
        collectionAddBody.setUserId(loginId);
        collectionService.cancelCollect(collectionAddBody);
        if (collectionAddBody.getType() == Type.MUSIC.getTypeNum()) {
            musicService.reduceCollectionCount(collectionAddBody.getTypeId());
        } else if (collectionAddBody.getType() == Type.PLAYLIST.getTypeNum()) {
            playlistService.reduceCollectionCount(collectionAddBody.getTypeId());
        } else if (collectionAddBody.getType() == Type.ALBUM.getTypeNum()) {
            albumService.reduceCollectionCount(collectionAddBody.getTypeId());
        } else if (collectionAddBody.getType() == Type.SINGER.getTypeNum()) {
            singerService.reduceCollectionCount(collectionAddBody.getTypeId());
        } else if (collectionAddBody.getType() == Type.MV.getTypeNum()) {
            mvService.reduceCollectionCount(collectionAddBody.getTypeId());
        }
        return Result.success();
    }
}
