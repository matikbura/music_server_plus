package com.lj.music_server_plus.controller.admin;

import com.lj.music_server_plus.common.result.Result;
import com.lj.music_server_plus.entity.Music;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/music")
@Tag(name = "AdminSinger", description = "管理员模块_音乐")
public class AdminSingerController {
    @PostMapping("getMusic")
    public Result<Music> getMusic() {
        return Result.success(null);
    }
}
