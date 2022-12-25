package com.lj.music_server_plus.interceptor;
import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.lj.music_server_plus.exception.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.Arrays;
import java.util.Map.Entry;

public class TokenInterceptor implements HandlerInterceptor {

    private String tokenKey;

    public TokenInterceptor(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取token
        System.out.println("----------------------------------------------");
        for (Entry<String, String[]> entry: request.getParameterMap().entrySet()) {
            System.out.println(entry.getKey() + " : " + Arrays.toString(entry.getValue()));
        }
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 获取token中的Role
        String role=null;
        try {
            JWT jwt = JWTUtil.parseToken(token);
            role = (String)jwt .getPayload("role");
        } catch (Exception e) {
            System.out.println(request.getRequestURI());
            throw new AuthException("token无效，请重新登录");
        }
        // 请求路径是否包含admin
        String requestURI = request.getRequestURI();
        if (requestURI.contains("admin")) {
            if (!"admin".equals(role)) {
                throw new AuthException("权限不足");
            }
        }
//        JWTValidator jwtValidator = JWTValidator.of(token).validateDate(DateUtil.date());
        // 验证token
        boolean validate = JWT.of(token).setKey(tokenKey.getBytes()).validate(0);
        if (!JWT.of(token).setKey(tokenKey.getBytes()).validate(0)) {
            throw new AuthException("token已过期，请重新登录");
        }
        //如果失效时间小于5分钟，生效时间加30分钟
        if ((Integer)JWT.of(token).setKey(tokenKey.getBytes()).getPayload(JWTPayload.EXPIRES_AT) - DateUtil.currentSeconds() < 300) {
            JWT jwt = JWT.of(token).setKey(tokenKey.getBytes());
            jwt.setPayload("exp", DateUtil.currentSeconds() + 1800);
            String newToken = jwt.sign();
            response.setHeader("token", newToken);
        }

        return true;
    }
}
