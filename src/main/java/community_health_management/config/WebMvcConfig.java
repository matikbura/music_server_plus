package community_health_management.config;

import community_health_management.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${token.key}")
    private String tokenKey;
    //跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }
    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        TokenInterceptor tokenInterceptor = new TokenInterceptor();
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                // 排除拦截
                //排除登录
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/admin/login")
                //排除注册
                .excludePathPatterns("/user/register")
                //排除swagger
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/v3/**")
                .excludePathPatterns("/doc.html")
                //排除文件上传
                .excludePathPatterns("/upload/**")
                .excludePathPatterns("/**/get**")
                .excludePathPatterns("/error")
                .excludePathPatterns("/resource/**");
    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("file:" + filePath);
//    }
}
