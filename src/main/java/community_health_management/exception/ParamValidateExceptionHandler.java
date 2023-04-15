package community_health_management.exception;

import community_health_management.comment.result.Result;
import community_health_management.comment.result.ResultCode;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Slf4j
@ControllerAdvice
@ResponseBody
public class ParamValidateExceptionHandler {
    /**
     * 忽略参数异常处理器
     *
     * @param e 忽略参数异常
     * @return ResponseResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class, UnexpectedTypeException.class,IllegalStateException.class})
    public Result<Void> parameterMissingExceptionHandler(MissingServletRequestParameterException e) {
        log.error("", e);
        return Result.failure(ResultCode.REQUEST_PARAM_ERROR.getCode(), "请求参数 " + e.getParameterName() + " 不能为空");
    }
    /**
     * 缺少请求体异常处理器
     *
     * @param e 缺少请求体异常
     * @return ResponseResult
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Void> parameterBodyMissingExceptionHandler(HttpMessageNotReadableException e) {
        log.error("", e);
        return Result.failure(ResultCode.REQUEST_PARAM_ERROR.getCode(), "参数体不能为空");
    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(MissingRequestHeaderException.class)
    public Result<Void> parameterHeaderMissingExceptionHandler(MissingRequestHeaderException e) {
        log.error("", e);
        return Result.failure(ResultCode.REQUEST_PARAM_ERROR.getCode(), e.toString());
    }

    /**
     * 参数效验异常处理器
     *
     * @param e 参数验证异常
     * @return ResponseInfo
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Void> parameterExceptionHandler(MethodArgumentNotValidException e) {
        log.error("", e);
        // 获取异常信息
        BindingResult exceptions = e.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                List<ObjectError> errors1 = errors;
                StringBuilder errorMessage = new StringBuilder();
                //拼接参数校验错误信息用分号隔开
                for (ObjectError objectError : errors1) {
                    errorMessage.append(objectError.getDefaultMessage());
                    errorMessage.append(";");
                }
                errorMessage.deleteCharAt(errorMessage.length() - 1);
                return Result.failure(ResultCode.REQUEST_PARAM_ERROR.getCode(), errorMessage.toString());
            }
        }
        return Result.failure(ResultCode.REQUEST_PARAM_ERROR);
    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthException.class)
    public Result<Void> authExceptionHandler(AuthException e) {
        return Result.failure(ResultCode.AUTHENTICATION_FAILED.getCode(), e.getMessage());
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public Result<Void> businessExceptionHandler(BusinessException e) {
        return Result.failure(ResultCode.REQUEST_PARAM_ERROR.getCode(), e.getMessage());
    }

    //拦截其他请求
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result<Void> exceptionHandler(Exception e) {
        log.error("", e);
        return Result.failure(ResultCode.PROGRAM_INSIDE_EXCEPTION);
    }
}
