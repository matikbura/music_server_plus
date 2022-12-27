package com.lj.music_server_plus.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lj.music_server_plus.body.user.PageQueryBody;
import com.lj.music_server_plus.body.user.singer.SingerQueryBody;
import com.lj.music_server_plus.common.ustils.BaseUtil;
import com.lj.music_server_plus.entity.Music;
import com.lj.music_server_plus.entity.Singer;
import com.lj.music_server_plus.entity.SingerLanguage;
import com.lj.music_server_plus.entity.SingerType;
import com.lj.music_server_plus.mapper.SingerLanguageMapper;
import com.lj.music_server_plus.mapper.SingerMapper;
import com.lj.music_server_plus.mapper.SingerTypeMapper;
import com.lj.music_server_plus.service.SingerService;
import com.lj.music_server_plus.vo.PageResult;
import com.lj.music_server_plus.vo.singer.SingerLessVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {
    private final SingerMapper singerMapper;
    private final SingerTypeMapper singerTypeMapper;
    private final SingerLanguageMapper singerLanguageMapper;
    public SingerServiceImpl(SingerMapper singerMapper, SingerTypeMapper singerTypeMapper, SingerLanguageMapper singerLanguageMapper) {
        this.singerMapper = singerMapper;
        this.singerTypeMapper = singerTypeMapper;
        this.singerLanguageMapper = singerLanguageMapper;
    }

    @Override
    public List<SingerLessVo> geSingerByMusicId(Integer musicId) {
        List<Music> music= singerMapper.geSingerByMusicId(musicId);
        return BaseUtil.convertList(music,SingerLessVo.class);
    }

    @Override
    public void addCollectionCount(Integer typeId) {
        singerMapper.addCollectionCount(typeId);
    }

    @Override
    public void reduceCollectionCount(Integer typeId) {
        singerMapper.reduceCollectionCount(typeId);
    }

    @Override
    public void addCommentCount(Integer targetId) {
        singerMapper.addCommentCount(targetId);
    }

    @Override
    public List<SingerType> getSingerTypeList() {
        return singerTypeMapper.findByAll(new SingerType());
    }

    @Override
    public List<SingerLanguage> getSingerLanguageList() {
        return singerLanguageMapper.findByAll(new SingerLanguage());
    }

    @Override
    public PageResult<SingerLessVo> getSingerListPage(PageQueryBody<SingerQueryBody> pageQueryBody) {
        PageHelper.startPage(pageQueryBody.getPageCurrent(), pageQueryBody.getPageSize());
        List<Singer> singerList = singerMapper.findByAll(BeanUtil.beanToMap(pageQueryBody.getCondition()));
        PageInfo<Singer> pageInfo = new PageInfo<>(singerList);
        PageResult<SingerLessVo> pageResult = new PageResult<>();
        pageResult.setData(BaseUtil.convertList(singerList, SingerLessVo.class));
        pageResult.setHasNext(pageInfo.isHasNextPage());
        pageResult.setTotal(pageInfo.getTotal());
        return pageResult;
    }
}
