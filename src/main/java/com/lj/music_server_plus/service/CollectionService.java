package com.lj.music_server_plus.service;

import com.lj.music_server_plus.body.user.collection.CollectionAddBody;
import com.lj.music_server_plus.body.user.collection.CollectionRemoveBody;
import com.lj.music_server_plus.common.result.Result;
import com.lj.music_server_plus.entity.MyCollection;

public interface CollectionService {
    Boolean isCollected(Integer loginId, Integer id, Integer type);

    MyCollection collect(CollectionAddBody collectionAddBody);

    void cancelCollect(CollectionRemoveBody collectionAddBody);

}
