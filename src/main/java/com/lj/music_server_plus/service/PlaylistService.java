package com.lj.music_server_plus.service;


import com.lj.music_server_plus.body.user.playlist.PlaylistAddBody;
import com.lj.music_server_plus.body.user.playlist.PlaylistQueryBody;
import com.lj.music_server_plus.entity.Playlist;
import com.lj.music_server_plus.vo.PageResult;
import com.lj.music_server_plus.vo.playlist.PlaylistBaseWithUserVo;
import com.lj.music_server_plus.vo.playlist.PlaylistLessVo;
import com.lj.music_server_plus.vo.playlist.PlaylistTypeVo;

import java.util.List;

public interface PlaylistService {
    PageResult<PlaylistBaseWithUserVo> getPlaylistListAndPage(Integer pageCurrent, Integer pageSize, PlaylistQueryBody condition);

    Playlist getPlayListDetail(Integer id);

    List<PlaylistTypeVo> getPlaylistStyleList();

    List<PlaylistLessVo> getPlaylistMoodList(Integer loginId);

    PlaylistLessVo addPlaylist(PlaylistAddBody playlistAddBody);

    void addCollectionCount(Integer typeId);

    void reduceCollectionCount(Integer typeId);

    void addCommentCount(Integer targetId);
}
