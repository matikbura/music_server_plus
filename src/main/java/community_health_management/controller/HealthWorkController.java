package community_health_management.controller;

import community_health_management.comment.result.Result;
import community_health_management.request.PageRequest;
import community_health_management.request.healthwork.AddHealthWorkRequest;
import community_health_management.request.healthwork.QueryHeathWorkRequest;
import community_health_management.request.healthwork.UpdateHeathWorkRequest;
import community_health_management.service.HealthWorkService;
import community_health_management.vo.HealthWorkVo;
import community_health_management.vo.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="卫生业务接口")
@RestController
@RequestMapping("healthwork")
public class HealthWorkController {
    @Resource
    HealthWorkService healthWorkService;
    @Operation(summary="添加")
    @PostMapping("add")
    public Result<String> add(@RequestBody AddHealthWorkRequest healthWork) {
        healthWorkService.insertSelective(healthWork);
        return Result.success("添加成功");
    }
    @Operation(summary="删除")
    @DeleteMapping("delete")
    public Result<String> delete(Integer hwid) {
        healthWorkService.deleteByPrimaryKey(hwid);
        return Result.success("删除成功");
    }
    @Operation(summary="修改")
    @PostMapping("update")
    public Result<String> update(@RequestBody UpdateHeathWorkRequest  healthWork) {
        healthWorkService.updateByPrimaryKeySelective(healthWork);
        return Result.success("修改成功");
    }
    @Operation(summary="查询所有")
    @PostMapping("findAll")
    public Result<List<HealthWorkVo>> findAll(@RequestBody QueryHeathWorkRequest healthWork) {
        return Result.success(healthWorkService.findAll(healthWork));
    }
    @Operation(summary="分页查询")
    @PostMapping("findPage")
    public Result<PageResult<HealthWorkVo>> findPage(@RequestBody PageRequest<QueryHeathWorkRequest> pageRequest) {
        return Result.success(healthWorkService.findPage(pageRequest));
    }
}
