package community_health_management.controller;

import community_health_management.comment.result.Result;
import community_health_management.entity.WorkPlace;
import community_health_management.request.PageRequest;
import community_health_management.service.WorkPlaceService;
import community_health_management.vo.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="工作场所接口")
@RestController
@RequestMapping("workplace")
public class WorkPlaceController {
    @Resource
    WorkPlaceService workPlaceService;
    @Operation(summary="添加")
    @GetMapping("add")
    public Result<String> add(String workplace){
        workPlaceService.add(workplace);
        return Result.success("添加成功");
    }
    @Operation(summary="删除")
    @GetMapping("delete")
    public Result<String> delete(Integer wpid){
        workPlaceService.delete(wpid);
        return Result.success("删除成功");
    }
    @Operation(summary="修改")
    @GetMapping("update")
    public Result<String> update(Integer wpid,String workplace){
        workPlaceService.update(wpid,workplace);
        return Result.success("修改成功");
    }
    @Operation(summary="查询所有")
    @GetMapping("findAll")
    public Result<List<WorkPlace>> findAll(){
        return Result.success(workPlaceService.findByAll(new WorkPlace()));
    }
    @Operation(summary="分页查询")
    @PostMapping("findPage")
    public Result<PageResult<WorkPlace>> findPage(@RequestBody @Validated PageRequest<WorkPlace> pageRequest){
        return Result.success(workPlaceService.findPage(pageRequest));
    }
}
