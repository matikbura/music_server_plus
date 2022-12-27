package com.lj.music_server_plus.service.impl;

import com.lj.music_server_plus.mapper.MvMapper;
import com.lj.music_server_plus.service.MvService;
import org.springframework.stereotype.Service;

@Service
public class MvServiceImpl implements MvService {
    private final MvMapper mvMapper;

    public MvServiceImpl(MvMapper mvMapper) {
        this.mvMapper = mvMapper;
    }

    @Override
    public void addCollectionCount(Integer typeId) {
        mvMapper.addCollectionCount(typeId);
    }

    @Override
    public void reduceCollectionCount(Integer typeId) {
        mvMapper.reduceCollectionCount(typeId);
    }

    @Override
    public void addCommentCount(Integer targetId) {
        mvMapper.addCommentCount(targetId);
    }
}
