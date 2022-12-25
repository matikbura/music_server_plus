package com.lj.music_server_plus.controller.user;
import com.lj.music_server_plus.common.result.Result;
import com.lj.music_server_plus.entity.Music;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Music",description = "音乐模块")
@RestController
@RequestMapping("music")
public class MusicController {
    @Operation(summary = "获取音乐")
    @GetMapping("getMusic")
    public Result<Music> getMusic() {
        return Result.success(null);
    }
}
