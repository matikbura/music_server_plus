package com.lj.music_server_plus.controller.user;

import com.lj.music_server_plus.common.result.Result;
import com.lj.music_server_plus.common.ustils.BaseUtil;
import com.lj.music_server_plus.entity.Lyric;
import com.lj.music_server_plus.entity.PlaylistMusic;
import com.lj.music_server_plus.enums.Type;
import com.lj.music_server_plus.service.AlbumService;
import com.lj.music_server_plus.service.CollectionService;
import com.lj.music_server_plus.service.MusicService;
import com.lj.music_server_plus.service.SingerService;
import com.lj.music_server_plus.vo.music.MusicLessVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Tag(name = "Music", description = "音乐模块")
@RestController
@RequestMapping("music")
public class MusicController {
    private final MusicService musicService;
    private final CollectionService CollectionService;
    private final SingerService singerService;
    private final AlbumService albumService;
    public MusicController(MusicService musicService, com.lj.music_server_plus.service.CollectionService collectionService, SingerService singerService, AlbumService albumService) {
        this.musicService = musicService;
        CollectionService = collectionService;
        this.singerService = singerService;
        this.albumService = albumService;
    }

    @Operation(summary = "通过歌单id获取音乐")
    @GetMapping("getMusicByPlaylistId")
    public Result<List<MusicLessVo>> getMusicByPlaylistId(Integer playlistId, HttpServletRequest request) {
        List<MusicLessVo> musicLessVos = musicService.getMusicByPlaylistId(playlistId);
        Integer loginId = BaseUtil.getLoginId(request,false);
        for (MusicLessVo musicLessVo : musicLessVos) {
            musicLessVo.setAlbum(albumService.getAlbumByPrimaryKey(musicLessVo.getAlbumId()));
            musicLessVo.setSingers(singerService.geSingerByMusicId(musicLessVo.getId()));
            Optional.ofNullable(loginId).ifPresent(id -> {
                musicLessVo.setIsCollected(CollectionService.isCollected(id, musicLessVo.getId(), Type.MUSIC.getTypeNum()));
            });}
        return Result.success(musicLessVos);
    }
    @Operation(summary = "通过音乐id获取歌词")
    @GetMapping("getLyricByMusicId")
    public Result<Lyric> getLyricByMusicId(Integer musicId) {
        return Result.success(musicService.getLyricByMusicId(musicId));
    }
    @Operation(summary = "添加音乐至歌单")
    @PostMapping("addMusicToPlaylist")
    public Result<PlaylistMusic> addMusicToPlaylist(@RequestBody PlaylistMusic playlistMusic) {
        musicService.addMusicToPlaylist(playlistMusic);
        return Result.success(playlistMusic);
    }
    @Operation(summary = "删除歌单中的音乐")
    @DeleteMapping("deleteMusicFromPlaylist")
    public Result<Void> deleteMusicFromPlaylist(PlaylistMusic playlistMusic) {
        musicService.deleteMusicFromPlaylist(playlistMusic);
        return Result.success();
    }
}
