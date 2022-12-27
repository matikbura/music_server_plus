package com.lj.music_server_plus.service;

import com.lj.music_server_plus.entity.Lyric;
import com.lj.music_server_plus.entity.PlaylistMusic;
import com.lj.music_server_plus.vo.music.MusicLessVo;

import java.util.List;

public interface MusicService {
    List<MusicLessVo> getMusicByPlaylistId(Integer playlistId);

    Lyric getLyricByMusicId(Integer musicId);

    void addMusicToPlaylist(PlaylistMusic playlistMusic);

    void deleteMusicFromPlaylist(PlaylistMusic playlistMusic);

    void addCollectionCount(Integer typeId);

    void reduceCollectionCount(Integer typeId);

    void addCommentCount(Integer targetId);
}
