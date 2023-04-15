package community_health_management.controller;

import community_health_management.comment.result.Result;
import community_health_management.request.PageRequest;
import community_health_management.request.sanitary_apparatus_enter.AddSanitaryApparatusEnterRequest;
import community_health_management.request.sanitary_apparatus_enter.QuerySanitaryApparatusEnterRequest;
import community_health_management.service.SanitaryApparatusEnterService;
import community_health_management.vo.PageResult;
import community_health_management.vo.SanitaryApparatusEnterVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "SanitaryApparatusEnterController", description = "卫生器械入库管理")
@RestController
@RequestMapping("sanitaryApparatusEnter")
public class SanitaryApparatusEnterController {
    @Resource
    SanitaryApparatusEnterService sanitaryApparatusEnterService;

    @Operation(summary = "添加卫生器械入库")
    @PostMapping("add")
    public Result<Void> add(@RequestBody @Validated AddSanitaryApparatusEnterRequest addSanitaryApparatusEnterRequest) {
        sanitaryApparatusEnterService.add(addSanitaryApparatusEnterRequest);
        return Result.success();
    }
    @Operation(summary = "卫生器械入库列表")
    @GetMapping("list")
    public Result<Void> list() {
        return Result.success();
    }

    @Operation(summary = "卫生器械入库列表分页")
    @PostMapping("listPage")
    public Result<PageResult<SanitaryApparatusEnterVo>> listPage(@RequestBody @Validated PageRequest<QuerySanitaryApparatusEnterRequest> pageRequest) {
        return Result.success(sanitaryApparatusEnterService.listPage(pageRequest));
    }
}
