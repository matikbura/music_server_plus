package com.lj.music_server_plus.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wangbo
 * @date 2021/05/12
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    //成功提示码
    SUCCESS(20000, "成功"),
    //校验失败提示码
    AUTHENTICATION_FAILED(40001, "认证失败"),
    //自定义失败信息
    FAILURE(50000, "失败"),

    //通用错误码 50001~50099
    PROGRAM_INSIDE_EXCEPTION(50001, "程序内部异常"),
    REQUEST_PARAM_ERROR(50002, "请求参数错误");
    private final Integer code;
    private final String message;
}
