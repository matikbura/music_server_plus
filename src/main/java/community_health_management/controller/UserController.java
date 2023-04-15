package community_health_management.controller;

import cn.hutool.core.convert.Convert;
import community_health_management.annotation.RoleAnnotation;
import community_health_management.comment.result.Result;
import community_health_management.comment.ustils.BaseUtil;
import community_health_management.comment.ustils.TokenUtil;
import community_health_management.entity.User;
import community_health_management.exception.BusinessException;
import community_health_management.request.PageRequest;
import community_health_management.request.user.*;
import community_health_management.service.UserService;
import community_health_management.vo.PageResult;
import community_health_management.vo.UserVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;

    @Operation(summary = "用户登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody @Validated LoginRequest user) {
        String token = userService.login(user);
        return Result.success(token);
    }

    @GetMapping("getUserInfo")
    @Operation(summary = "获取用户信息")
    @RoleAnnotation
    public Result<UserVo> getUserInfo(@RequestHeader("Authorization") String token) {
        Integer id = TokenUtil.getId(token);
        return Result.success(Convert.convert(UserVo.class, userService.selectByPrimaryKey(id)));
    }

    //更新员工
    @Operation(summary = "用户更新")
    @PostMapping("update")
    public Result<Void> update(@RequestBody @Validated UpdateUserRequest request,@RequestHeader("Authorization") String token) {
        Integer id = TokenUtil.getId(token);
        request.setUid(id);
        userService.updateByPrimaryKeySelective(Convert.convert(community_health_management.entity.User.class, request));
        return Result.success();
    }

    //删除员工
    @Operation(summary = "删除员工")
    @DeleteMapping("delete")
    public Result<Void> delete(Integer uid) {
        userService.deleteByPrimaryKey(uid);
        return Result.success();
    }

    //添加员工
    @Operation(summary = "添加员工")
    @PostMapping("add")
    public Result<Void> add(@RequestBody @Validated AddUserRequest request) {
        userService.insertSelective(Convert.convert(User.class, request));
        return Result.success();
    }

    //查询所有员工
    @Operation(summary = "查询所有员工")
    @PostMapping("findAll")
    public Result<List<UserVo>> findAll(@RequestBody @Validated QueryUserRequest request) {
        List<User> byAll = userService.findByAll(Convert.convert(User.class, request));
        return Result.success(BaseUtil.convertList(byAll, UserVo.class));
    }

    //分页查询员工
    @Operation(summary = "分页查询员工")
    @PostMapping("findPage")
    public Result<PageResult<UserVo>> findPage(@RequestBody @Validated PageRequest<QueryUserRequest> pageRequest) {
        PageResult<UserVo> page = userService.findPage(pageRequest);
        return Result.success(page);
    }

    @Operation(summary = "发送验证码")
    @PostMapping("sendCode")
    public Result<Void> sendCode(@RequestParam String email, HttpServletRequest request) {
        String code = userService.sendCode(email);
        request.getSession().setAttribute("emailCode", code);
        return Result.success();
    }

    @Operation(summary = "忘记密码")
    @PostMapping("forgetPassword")
    public Result<Void> forgetPassword(@RequestBody @Validated ForgetPassword forgetPassword, HttpServletRequest request) {
        //验证码是否正确
        String code = (String) request.getSession().getAttribute("emailCode");
        if (!code.equals(forgetPassword.getCode())) {
            throw new BusinessException("验证码错误");
        }
        userService.forgetPassword(forgetPassword);
        return Result.success();
    }

}
