package com.lj.music_server_plus.service;

public interface MvService {
    void addCollectionCount(Integer typeId);

    void reduceCollectionCount(Integer typeId);

    void addCommentCount(Integer targetId);
}
