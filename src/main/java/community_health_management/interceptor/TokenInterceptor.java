package community_health_management.interceptor;

import community_health_management.annotation.RoleAnnotation;
import community_health_management.annotation.NonAuth;
import community_health_management.comment.ustils.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class TokenInterceptor implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        Integer type = null; //管理员类型
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //获取方法上的注解 如果有AdminAnnotation 说明是管理员的方法 type设为1
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        NonAuth nonAuth = handlerMethod.getMethod().getAnnotation(NonAuth.class);
        //如果有NonAuth注解 说明不需要验证token 直接通过
        if (nonAuth != null) {
            return true;
        }
        RoleAnnotation annotation = handlerMethod.getMethod().getAnnotation(RoleAnnotation.class);
        if (annotation != null) {
            type = annotation.value();
        }
        TokenUtil.verify(token, type, response);
        return true;
    }
}