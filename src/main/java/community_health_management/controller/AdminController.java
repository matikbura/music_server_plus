package community_health_management.controller;

import community_health_management.comment.result.Result;
import community_health_management.entity.Admin;
import community_health_management.request.admin.LoginRequest;
import community_health_management.service.AdminService;
import community_health_management.vo.AdminVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="管理员接口")
@RequestMapping("admin")
@RestController
public class AdminController {
    @Resource
    AdminService adminService;
    @Operation(summary="管理员登录")
    @PostMapping("login")
    public Result<AdminVo> login(@RequestBody @Validated LoginRequest login){
        AdminVo adminVo =  adminService.login(login);
        return Result.success(adminVo);
    }
    @Operation(summary="修改")
    @PostMapping("update")
    public Result<String> update(@RequestBody Admin admin){
        adminService.updateByPrimaryKeySelective(admin);
        return Result.success("修改成功");
    }
}
