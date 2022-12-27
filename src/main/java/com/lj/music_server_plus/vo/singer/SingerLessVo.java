package com.lj.music_server_plus.vo.singer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "SingerLessVo",description = "歌手-少量信息")
public class SingerLessVo {
    //歌手id
    @Schema(name = "id",description = "歌手id")
    private Integer id;
    //歌手名称
    @Schema(name = "name",description = "歌手名称")
    private String name;
    //歌手封面
    @Schema(name = "cover",description = "歌手封面")
    private String cover;
    //专辑总量
    @Schema(name = "albumCount",description = "专辑总量")
    private Integer albumCount;
    //歌曲总量
    @Schema(name = "musicCount",description = "歌曲总量")
    private Integer musicCount;
    //点击量
    @Schema(name = "clickCount",description = "点击量")
    private Integer clickCount;
    //收藏量
    @Schema(name = "collectionCount",description = "收藏量")
    private Integer collectionCount;
    //评论量
    @Schema(name = "commentCount",description = "评论量")
    private Integer commentCount;
}
