package community_health_management.controller;

import community_health_management.annotation.RoleAnnotation;
import community_health_management.comment.result.Result;
import community_health_management.comment.ustils.TokenUtil;
import community_health_management.entity.Task;
import community_health_management.request.PageRequest;
import community_health_management.request.task.QueryTaskReuqest;
import community_health_management.request.task.UpdateForCompleteRequest;
import community_health_management.request.task.UpdateForProcessRequest;
import community_health_management.request.task.UpdateForRejectRequest;
import community_health_management.service.TaskService;
import community_health_management.vo.PageResult;
import community_health_management.vo.TaskVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "任务模块")
@RequestMapping("task")
public class TaskController {
    @Resource
    TaskService taskService;
    @Operation(summary = "任务列表")
    @PostMapping("list")
    public Result<List<TaskVo>> taskList(@RequestBody QueryTaskReuqest queryTaskReuqest) {
        return Result.success(taskService.list(queryTaskReuqest));
    }
    @Operation(summary = "任务添加")
    @PostMapping("add")
    @RoleAnnotation(2)
    public Result<String> add(@RequestBody Task task,@RequestHeader("Authorization") String token) {
        Integer id = TokenUtil.getId(token);
        task.setEnforcerId(id);
        taskService.insertSelective(task);
        return Result.success("添加成功");
    }
    @Operation(summary = "任务详情")
    @GetMapping("detail")
    public Result<TaskVo> taskDetail(Integer tid) {
        return Result.success(taskService.detail(tid));
    }
    @Operation(summary = "处理超时任务")
    @PostMapping("updateForProject")
    public Result<String> updateForProcess(@RequestBody UpdateForProcessRequest updateForProcessRequest) {
        taskService.updateForProcess(updateForProcessRequest);
        return Result.success("处理成功");
    }
    @Operation(summary = "任务完成")
    @PostMapping("updateForComplete")
    public Result<String> updateForComplete(@RequestBody UpdateForCompleteRequest update) {
        taskService.updateForComplete(update);
        return Result.success("处理成功");
    }

    @Operation(summary = "任务通过")
    @GetMapping("updateForPass")
    public Result<String> updateForPass(int tid) {
        taskService.updateForPass(tid);
        return Result.success("处理成功");
    }

    @Operation(summary = "任务驳回")
    @PostMapping("updateForReject")
    public Result<String> updateForReject(@RequestBody UpdateForRejectRequest update) {
        taskService.updateForReject(update);
        return Result.success("处理成功");
    }
    @Operation(summary = "任务申述")
    @PostMapping("updateForAppeal")
    public Result<String> updateForAppeal(@RequestBody UpdateForRejectRequest update) {
        taskService.updateForAppeal(update);
        return Result.success("处理成功");
    }

    @Operation(summary = "任务列表分页")
    @PostMapping("listPage")
    public Result<PageResult<TaskVo>> listPage(@RequestBody PageRequest<QueryTaskReuqest> queryTaskReuqest) {
        return Result.success(taskService.listPage(queryTaskReuqest));
    }

}
