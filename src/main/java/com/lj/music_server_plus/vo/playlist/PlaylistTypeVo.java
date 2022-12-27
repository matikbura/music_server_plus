package com.lj.music_server_plus.vo.playlist;

import com.lj.music_server_plus.entity.PlaylistStyle;
import com.lj.music_server_plus.entity.PlaylistStyleTag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Schema(name = "PlaylistBaseVo",description = "歌单风格-基础信息")
@Data
public class PlaylistTypeVo extends PlaylistStyle {
    @Schema(name = "tags",description = "歌单风格全部标签")
    List<PlaylistStyleTag> tags;
}
