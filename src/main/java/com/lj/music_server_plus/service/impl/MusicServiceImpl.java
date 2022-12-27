package com.lj.music_server_plus.service.impl;

import com.lj.music_server_plus.common.ustils.BaseUtil;
import com.lj.music_server_plus.entity.Lyric;
import com.lj.music_server_plus.entity.Music;
import com.lj.music_server_plus.entity.PlaylistMusic;
import com.lj.music_server_plus.exception.BusinessException;
import com.lj.music_server_plus.mapper.LyricMapper;
import com.lj.music_server_plus.mapper.MusicMapper;
import com.lj.music_server_plus.mapper.PlaylistMusicMapper;
import com.lj.music_server_plus.service.MusicService;
import com.lj.music_server_plus.vo.music.MusicLessVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {
    private final MusicMapper musicMapper;
    private final LyricMapper lyricMapper;

    private final PlaylistMusicMapper playlistMusicMapper;
    public MusicServiceImpl(MusicMapper musicMapper, LyricMapper lyricMapper, PlaylistMusicMapper playlistMusicMapper) {
        this.musicMapper = musicMapper;
        this.lyricMapper = lyricMapper;
        this.playlistMusicMapper = playlistMusicMapper;
    }

    @Override
    public List<MusicLessVo> getMusicByPlaylistId(Integer playlistId) {
        List<Music> music = musicMapper.getMusicByPlaylistId(playlistId);
        return BaseUtil.convertList(music, MusicLessVo.class);
    }

    @Override
    public Lyric getLyricByMusicId(Integer musicId) {
        Lyric lyric = new Lyric();
        lyric.setMusicId(musicId);
        return lyricMapper.findOneByAll(lyric);
    }

    @Override
    public void addMusicToPlaylist(PlaylistMusic playlistMusic) {
        Optional.ofNullable(playlistMusicMapper.findOneByAll(playlistMusic)).ifPresentOrElse(
                (pm) -> {
                    throw new BusinessException("歌单中已存在该歌曲");
                },
                () -> {
                    playlistMusicMapper.insert(playlistMusic);
                }
        );
    }

    @Override
    public void deleteMusicFromPlaylist(PlaylistMusic playlistMusic) {
        Optional.ofNullable(playlistMusicMapper.findOneByAll(playlistMusic)).ifPresentOrElse(
                (pm) -> {
                    playlistMusicMapper.deleteByAll(playlistMusic);
                },
                () -> {
                    throw new BusinessException("歌单中不存在该歌曲");
                }
        );
    }

    @Override
    public void addCollectionCount(Integer typeId) {
        musicMapper.addCollectionCount(typeId);
    }

    @Override
    public void reduceCollectionCount(Integer typeId) {
        musicMapper.reduceCollectionCount(typeId);
    }

    @Override
    public void addCommentCount(Integer targetId) {
        musicMapper.addCommentCount(targetId);
    }
}
