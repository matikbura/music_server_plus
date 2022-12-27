package com.lj.music_server_plus.vo.playlist;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "PlaylistLessVo",description = "歌单-少量信息")
public class PlaylistLessVo {
    @Schema(name = "id",description = "id")
    private Integer id;
    @Schema(name = "name",description = "歌单名称")
    private String name;
    @Schema(name = "cover",description = "歌单封面")
    private String cover;
    @Schema(name = "clickCount",description = "点击量")
    private Integer clickCount;
    @Schema(name = "commentCount",description = "歌单评论数量")
    private Integer commentCount;
    @Schema(name = "collectionCount",description = "歌单收藏数量")
    private Integer collectionCount;
    @Schema(name = "musicCount",description = "歌单歌曲数量")
    private Integer musicCount;
    @Schema(name = "userId",description = "创建者id")
    private Integer userId;
}
