package com.lj.music_server_plus.service.impl;

import cn.hutool.core.convert.Convert;
import com.lj.music_server_plus.body.user.collection.CollectionAddBody;
import com.lj.music_server_plus.body.user.collection.CollectionRemoveBody;
import com.lj.music_server_plus.common.result.Result;
import com.lj.music_server_plus.entity.MyCollection;
import com.lj.music_server_plus.exception.BusinessException;
import com.lj.music_server_plus.mapper.CollectionMapper;
import com.lj.music_server_plus.service.CollectionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollectionServiceImpl implements CollectionService {
    private final CollectionMapper collectionMapper;

    public CollectionServiceImpl(CollectionMapper collectionMapper) {
        this.collectionMapper = collectionMapper;
    }

    @Override
    public Boolean isCollected(Integer loginId, Integer id, Integer type) {
        MyCollection myCollection = new MyCollection();
        myCollection.setUserId(loginId);
        myCollection.setTypeId(id);
        myCollection.setType(type);
        return collectionMapper.findOneByAll(myCollection) !=null;
    }

    @Override
    public MyCollection collect(CollectionAddBody collectionAddBody) {
        MyCollection convert = Convert.convert(MyCollection.class, collectionAddBody);
        Optional.ofNullable(isCollected(convert.getUserId(), convert.getTypeId(), convert.getType())).ifPresentOrElse(
                (isCollected) -> {
                    if (isCollected) {
                        throw new BusinessException("已收藏");
                    }else {
                        collectionMapper.insert(convert);
                    }
                },
                () -> {
                    collectionMapper.insert(convert);
                }
        );
        return convert;
    }

    @Override
    public void cancelCollect(CollectionRemoveBody collectionAddBody) {
        MyCollection convert = Convert.convert(MyCollection.class, collectionAddBody);
        Optional.ofNullable(collectionMapper.findOneByAll(convert)).ifPresentOrElse(
                (myCollection) -> {
                    collectionMapper.deleteByPrimaryKey(myCollection.getId());
                },
                () -> {
                    throw new BusinessException("您还未收藏");
                }
        );
    }

}
