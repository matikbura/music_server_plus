package community_health_management.comment.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wangbo
 * @date 2021/05/12
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    SUCCESS(200, "成功"),
    AUTHENTICATION_FAILED(401, "认证失败"),
    PROGRAM_INSIDE_EXCEPTION(500, "程序内部异常"),
    REQUEST_PARAM_ERROR(400, "请求参数错误"),
    // 业务逻辑异常异常
    BUSINESS_ERROR(410, "业务逻辑异常"),
    USERNAME_OR_PASSWORD_ERROR(400159,"用户名或密码错误");
    private final Integer code;
    private final String message;
}
