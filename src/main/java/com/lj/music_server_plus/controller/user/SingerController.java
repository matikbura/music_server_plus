package com.lj.music_server_plus.controller.user;

import com.lj.music_server_plus.body.user.PageQueryBody;
import com.lj.music_server_plus.body.user.singer.SingerQueryBody;
import com.lj.music_server_plus.common.result.Result;
import com.lj.music_server_plus.entity.SingerLanguage;
import com.lj.music_server_plus.entity.SingerType;
import com.lj.music_server_plus.service.SingerService;
import com.lj.music_server_plus.vo.PageResult;
import com.lj.music_server_plus.vo.singer.SingerLessVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@Tag(name = "歌手模块")
@RestController
@RequestMapping("singer")
public class SingerController {
    private final SingerService singerService;
    public SingerController(SingerService singerService) {
        this.singerService = singerService;
    }

    @Operation(summary = "获取歌手类型列表")
    @GetMapping("getSingerTypeList")
    public Result<List<SingerType>> getSingerTypeList(){
        return Result.success(singerService.getSingerTypeList());
    }

    @Operation(summary = "获取歌手语言列表")
    @GetMapping("getSingerLanguageList")
    public Result<List<SingerLanguage>> getSingerLanguageList(){
        return Result.success(singerService.getSingerLanguageList());
    }
    @Operation(summary = "获取歌手列表并分页")
    @PostMapping("getSingerListPage")
    public Result<PageResult<SingerLessVo>> getSingerListPage(@RequestBody @Validated PageQueryBody<SingerQueryBody> pageQueryBody){
        PageResult<SingerLessVo> singerListPage = singerService.getSingerListPage(pageQueryBody);
        return Result.success(singerListPage);
    }
}
