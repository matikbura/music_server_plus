package community_health_management.controller;

import community_health_management.comment.result.Result;
import community_health_management.comment.ustils.TokenUtil;
import community_health_management.entity.LeavePermit;
import community_health_management.request.PageRequest;
import community_health_management.request.leave_permit.QueryLeavePermitRequest;
import community_health_management.service.LeavePermitService;
import community_health_management.vo.LeavePermitVo;
import community_health_management.vo.PageResult;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "假条模块")
@RestController
@RequestMapping("permit")
public class PermitController {
    @Resource
    LeavePermitService leavePermitService;

    @PostMapping("list")
    @Schema(description = "假条列表")
    public Result<List<LeavePermitVo>> list() {
        return Result.success(leavePermitService.list());
    }

    @PostMapping("add")
    @Schema(description = "假条添加")
    public Result<String> add(@RequestBody LeavePermit leavePermit) {
        leavePermitService.insertSelective(leavePermit);
        return Result.success("添加成功");
    }

    @GetMapping("detail")
    @Schema(description = "假条详情")
    public Result<LeavePermitVo> detail(Integer lid) {
        return Result.success(leavePermitService.detail(lid));
    }

    @Schema(description = "假条审核")
    @PostMapping("updateForAudit")
    public Result<String> updateForAudit(@RequestBody LeavePermit leavePermit, @RequestHeader("Authorization") String token) {
        Integer id = TokenUtil.getId(token);
        leavePermit.setCheckerId(id);
        leavePermitService.updateForAudit(leavePermit);
        return Result.success("处理成功");
    }
    @Schema(description = "假条列表并分页")
    @PostMapping("listPage")
    public Result<PageResult<LeavePermitVo>> listPage(@RequestBody @Validated PageRequest<QueryLeavePermitRequest> pageRequest) {
        return Result.success(leavePermitService.listPage(pageRequest));
    }
}
