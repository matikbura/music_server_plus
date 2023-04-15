package community_health_management.controller;

import community_health_management.comment.result.Result;
import community_health_management.entity.SanitaryApparatus;
import community_health_management.request.PageRequest;
import community_health_management.request.sanitary_apparatus.AddSanitaryApparatusRequest;
import community_health_management.request.sanitary_apparatus.QuerySanitaryApparatusRequest;
import community_health_management.request.sanitary_apparatus.UpdateSanitaryApparatusRequest;
import community_health_management.service.SanitaryApparatusService;
import community_health_management.vo.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sanitaryApparatus")
@Tag(name = "卫生器械模块")
public class SanitaryApparatusController {
    @Resource
    SanitaryApparatusService sanitaryApparatusService;
    @Operation(summary = "卫生器械列表")
    @PostMapping("list")
    public Result<List<SanitaryApparatus>> list() {
        return Result.success(sanitaryApparatusService.list());
    }
    @Operation(summary = "卫生器械添加")
    @PostMapping("add")
    public Result<Void> add(AddSanitaryApparatusRequest addSanitaryApparatusRequest) {
        sanitaryApparatusService.add(addSanitaryApparatusRequest);
        return Result.success();
    }
    @Operation(summary = "卫生器械删除")
    @PostMapping("delete")
    public Result<Void> delete(Integer said) {
        sanitaryApparatusService.deleteByPrimaryKey(said);
        return Result.success();
    }
    @Operation(summary = "卫生器械修改")
    @PostMapping("update")
    public Result<Void> update(UpdateSanitaryApparatusRequest updateSanitaryApparatusRequest) {
        sanitaryApparatusService.update(updateSanitaryApparatusRequest);
        return Result.success();
    }
    @Operation(summary = "卫生器械列表分页")
    @PostMapping("listPage")
    public Result<PageResult<SanitaryApparatus>> listPage(@RequestBody @Validated PageRequest<QuerySanitaryApparatusRequest> pageRequest) {
        return Result.success(sanitaryApparatusService.listPage(pageRequest));
    }
}
