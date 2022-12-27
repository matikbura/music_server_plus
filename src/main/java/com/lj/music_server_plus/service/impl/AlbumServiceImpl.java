package com.lj.music_server_plus.service.impl;

import cn.hutool.core.convert.Convert;
import com.lj.music_server_plus.entity.Album;
import com.lj.music_server_plus.mapper.AlbumMapper;
import com.lj.music_server_plus.service.AlbumService;
import com.lj.music_server_plus.vo.album.AlbumLessVo;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumMapper albumMapper;

    public AlbumServiceImpl(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }

    @Override
    public AlbumLessVo getAlbumByPrimaryKey(Integer albumId) {
        Album album = albumMapper.selectByPrimaryKey(albumId);
        return Convert.convert(AlbumLessVo.class, album);
    }

    @Override
    public void addCollectionCount(Integer typeId) {
        albumMapper.addCollectionCount(typeId);
    }

    @Override
    public void reduceCollectionCount(Integer typeId) {
        albumMapper.reduceCollectionCount(typeId);
    }

    @Override
    public void addCommentCount(Integer targetId) {
        albumMapper.addCommentCount(targetId);
    }
}
