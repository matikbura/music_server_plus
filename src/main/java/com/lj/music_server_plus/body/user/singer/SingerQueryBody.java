package com.lj.music_server_plus.body.user.singer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(name = "SingerQueryBody", description = "歌手-查询请求体")
public class SingerQueryBody {
    @Schema(name = "name", description = "歌手名")
    private String name;
    @Schema(name = "singerTypeId", description = "歌手类型id")
    private Integer singerTypeId;
    @Schema(name = "singerLanguageId", description = "歌手语言id")
    private Integer singerLanguageId;
    @Schema(name="nameStart", description = "歌手名首字母")
    private String nameStart;
    @Schema(name="sortFields",description = "排序字段")
    private List<String> sortFields;
}
