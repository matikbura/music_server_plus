package community_health_management.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public GroupedOpenApi workplaceApi() {
        return GroupedOpenApi.builder()
                .group("工作地点模块")
                .pathsToMatch("/workplace/**")
                .build();
    }

    @Bean
    public GroupedOpenApi healthworktApi() {
        return GroupedOpenApi.builder()
                .group("卫生业务模块")
                .pathsToMatch("/healthwork/**")
                .build();
    }

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("用户模块")
                .pathsToMatch("/user/**")
                .build();
    }


    @Bean
    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group("管理员模块")
                .pathsToMatch("/admin/**")
                .build();
    }

    @Bean
    public GroupedOpenApi resourceApi() {
        return GroupedOpenApi.builder()
                .group("资源模块")
                .pathsToMatch("/resource/**")
                .build();
    }

    @Bean
    public GroupedOpenApi taskApi() {
        return GroupedOpenApi.builder()
                .group("任务模块")
                .pathsToMatch("/task/**")
                .build();
    }

    @Bean
    public GroupedOpenApi permitApi() {
        return GroupedOpenApi.builder()
                .group("假条模块")
                .pathsToMatch("/permit/**")
                .build();
    }

    @Bean
    public GroupedOpenApi sanitaryApparatusApi() {
        return GroupedOpenApi.builder()
                .group("器械模块")
                .pathsToMatch("/sanitaryApparatus/**")
                .build();
    }

    @Bean
    public GroupedOpenApi sanitaryApparatusEnterApi() {
        return GroupedOpenApi.builder()
                .group("器械入库模块")
                .pathsToMatch("/sanitaryApparatusEnter/**")
                .build();
    }

    @Bean
    public GroupedOpenApi sanitaryApparatusLossApi() {
        return GroupedOpenApi.builder()
                .group("器械报损模块")
                .pathsToMatch("/sanitaryApparatusLoss/**")
                .build();
    }
}
