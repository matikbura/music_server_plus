package community_health_management.controller;

import community_health_management.comment.result.Result;
import community_health_management.entity.SanitaryApparatusLoss;
import community_health_management.request.PageRequest;
import community_health_management.request.sanitary_apparatus_loss.AddSanitaryApparatusLossRequest;
import community_health_management.request.sanitary_apparatus_loss.QuerySanitaryApparatusLossRequest;
import community_health_management.service.SanitaryApparatusLossService;
import community_health_management.vo.PageResult;
import community_health_management.vo.SanitaryApparatusLossVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "SanitaryApparatusLossController", description = "卫生器械损耗管理")
@RestController
@RequestMapping("sanitaryApparatusLoss")
public class SanitaryApparatusLossController {
    @Resource
    SanitaryApparatusLossService sanitaryApparatusLossService;

    @Operation(summary = "添加卫生器械损耗")
    @PostMapping("add")
    public Result<Void> add(@RequestBody @Validated AddSanitaryApparatusLossRequest addSanitaryApparatusLossRequest) {
        sanitaryApparatusLossService.add(addSanitaryApparatusLossRequest);
        return Result.success();
    }
    @Operation(summary = "卫生器械损耗列表并分页")
    @PostMapping("listPage")
    public Result<PageResult<SanitaryApparatusLossVo>> listPage(@RequestBody @Validated PageRequest<QuerySanitaryApparatusLossRequest> pageRequest) {
        return Result.success(sanitaryApparatusLossService.listPage(pageRequest));
    }

}
