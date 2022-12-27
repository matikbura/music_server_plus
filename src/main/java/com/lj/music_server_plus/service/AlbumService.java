package com.lj.music_server_plus.service;

import com.lj.music_server_plus.vo.album.AlbumLessVo;

public interface AlbumService {
    AlbumLessVo getAlbumByPrimaryKey(Integer albumId);

    void addCollectionCount(Integer typeId);

    void reduceCollectionCount(Integer typeId);

    void addCommentCount(Integer targetId);
}
