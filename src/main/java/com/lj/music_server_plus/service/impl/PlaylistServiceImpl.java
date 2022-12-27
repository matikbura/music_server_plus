package com.lj.music_server_plus.service.impl;

import cn.hutool.core.convert.Convert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lj.music_server_plus.body.user.playlist.PlaylistAddBody;
import com.lj.music_server_plus.body.user.playlist.PlaylistQueryBody;
import com.lj.music_server_plus.common.ustils.BaseUtil;
import com.lj.music_server_plus.entity.Playlist;
import com.lj.music_server_plus.entity.PlaylistStyle;
import com.lj.music_server_plus.entity.PlaylistStyleTag;
import com.lj.music_server_plus.mapper.PlaylistMapper;
import com.lj.music_server_plus.mapper.PlaylistStyleMapper;
import com.lj.music_server_plus.mapper.PlaylistStyleTagMapper;
import com.lj.music_server_plus.service.PlaylistService;
import com.lj.music_server_plus.vo.PageResult;
import com.lj.music_server_plus.vo.playlist.PlaylistBaseWithUserVo;
import com.lj.music_server_plus.vo.playlist.PlaylistLessVo;
import com.lj.music_server_plus.vo.playlist.PlaylistTypeVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistMapper playlistMapper;
    private final PlaylistStyleMapper playlistStyleMapper;
    private final PlaylistStyleTagMapper playlistStyleTagMapper;

    public PlaylistServiceImpl(PlaylistMapper playlistMapper, PlaylistStyleMapper playlistStyleMapper, PlaylistStyleTagMapper playlistStyleTagMapper) {
        this.playlistMapper = playlistMapper;
        this.playlistStyleMapper = playlistStyleMapper;
        this.playlistStyleTagMapper = playlistStyleTagMapper;
    }

    @Override
    public PageResult<PlaylistBaseWithUserVo> getPlaylistListAndPage(Integer pageCurrent, Integer pageSize, PlaylistQueryBody condition) {
        PageHelper.startPage(pageCurrent, pageSize);
        Playlist playlist = Convert.convert(Playlist.class, condition);
        List<Playlist> byAll = playlistMapper.findByAll(playlist);
        PageInfo<Playlist> pageInfo = new PageInfo<>(byAll);
        List<Playlist> list = pageInfo.getList();
        PageResult<PlaylistBaseWithUserVo> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setHasNext(pageInfo.isHasNextPage());
        pageResult.setData(BaseUtil.convertList(list, PlaylistBaseWithUserVo.class));
        return pageResult;
    }

    @Override
    public Playlist getPlayListDetail(Integer id) {
        //获取创建者信息
        return playlistMapper.selectDetailByPrimaryKey(id);
    }

    @Override
    public List<PlaylistTypeVo> getPlaylistStyleList() {
        List<PlaylistStyle> byAll = playlistStyleMapper.findByAll(null);
        List<PlaylistTypeVo> playlistTypeVos = BaseUtil.convertList(byAll, PlaylistTypeVo.class);
        for (PlaylistTypeVo playlistTypeVo : playlistTypeVos) {
            PlaylistStyleTag playlistStyleTag = new PlaylistStyleTag();
            playlistStyleTag.setPlaylistStyleId(playlistTypeVo.getId());
            playlistTypeVo.setTags(playlistStyleTagMapper.findByAll(playlistStyleTag));
        }
        return playlistTypeVos;
    }

    @Override
    public List<PlaylistLessVo> getPlaylistMoodList(Integer loginId) {
        Playlist playlist = new Playlist();
        playlist.setUserId(loginId);
        List<Playlist> byAll = playlistMapper.findByAll(playlist);
        return BaseUtil.convertList(byAll, PlaylistLessVo.class);
    }

    @Override
    public PlaylistLessVo addPlaylist(PlaylistAddBody playlistAddBody) {
        Playlist playlist = Convert.convert(Playlist.class, playlistAddBody);
        playlistMapper.insert(playlist);
        return Convert.convert(PlaylistLessVo.class, playlist);
    }

    @Override
    public void addCollectionCount(Integer typeId) {
        playlistMapper.addCollectionCount(typeId);
    }

    @Override
    public void reduceCollectionCount(Integer typeId) {
        playlistMapper.reduceCollectionCount(typeId);
    }

    @Override
    public void addCommentCount(Integer targetId) {
        playlistMapper.addCommentCount(targetId);
    }
}
