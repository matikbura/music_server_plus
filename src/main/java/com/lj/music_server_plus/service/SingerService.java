package com.lj.music_server_plus.service;

import com.lj.music_server_plus.body.user.PageQueryBody;
import com.lj.music_server_plus.body.user.singer.SingerQueryBody;
import com.lj.music_server_plus.entity.SingerLanguage;
import com.lj.music_server_plus.entity.SingerType;
import com.lj.music_server_plus.vo.PageResult;
import com.lj.music_server_plus.vo.singer.SingerLessVo;

import java.util.List;

public interface SingerService {
    List<SingerLessVo> geSingerByMusicId(Integer id);

    void addCollectionCount(Integer typeId);

    void reduceCollectionCount(Integer typeId);

    void addCommentCount(Integer targetId);

    List<SingerType> getSingerTypeList();

    List<SingerLanguage> getSingerLanguageList();

    PageResult<SingerLessVo> getSingerListPage(PageQueryBody<SingerQueryBody> pageQueryBody);
}
