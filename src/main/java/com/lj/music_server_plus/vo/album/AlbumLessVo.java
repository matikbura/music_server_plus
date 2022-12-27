package com.lj.music_server_plus.vo.album;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "AlbumLessVo", description = "专辑-少量信息")
public class AlbumLessVo {
    @Schema(name = "id",description = "专辑id")
    private Integer id;
    @Schema(name="name",description = "专辑名")
    private String name;
    @Schema(name="cover",description = "专辑封面")
    private String cover;
    @Schema(name = "clickCount",description = "专辑点击量")
    private Integer clickCount;
    @Schema(name = "commentCount",description = "专辑评论数量")
    private Integer commentCount;
    @Schema(name = "collectionCount",description = "专辑收藏数量")
    private Integer collectionCount;
    @Schema(name = "musicCount",description = "专辑歌曲数量")
    private Integer musicCount;
    @Schema(name = "singerId",description = "歌手id")
    private Integer singerId;
}
