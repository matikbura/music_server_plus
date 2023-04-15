package community_health_management.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RoleAnnotation {
    //0 管理员 1 普通职员 3 队长
    int value() default -1;
}
