package com.lj.music_server_plus.vo.playlist;
import com.lj.music_server_plus.vo.user.UserLess;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "PlaylistBaseWithUserVo",description = "歌单基础信息-带用户信息")
public class PlaylistBaseWithUserVo extends PlaylistLessVo {
    private UserLess user;
    private Boolean isCollected;
}
