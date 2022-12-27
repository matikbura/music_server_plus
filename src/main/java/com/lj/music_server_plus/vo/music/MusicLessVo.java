package com.lj.music_server_plus.vo.music;

import com.lj.music_server_plus.vo.album.AlbumLessVo;
import com.lj.music_server_plus.vo.singer.SingerLessVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Schema(description = "音乐-少量信息")
@Data
public class MusicLessVo {
    private Integer id;

    private String name;

    private String url;

    private String duration;

    private String durationSecond;

    private String createTime;

    private String modifiedTime;

    private Integer albumId;

    private Integer clickCount;

    private Integer commentCount;

    private Integer collectionCount;

    private Integer mvId;
    private AlbumLessVo album;
    private List<SingerLessVo> singers;
    private Boolean isCollected;
}
