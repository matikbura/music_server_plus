package com.lj.music_server_plus.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    //     @Bean
//    public OpenAPI springShopOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("SpringShop API")
//                        .description("Spring shop sample application")
//                        .version("v0.0.1")
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
//                        .externalDocs(new ExternalDocumentation()
//                        .description("SpringShop Wiki Documentation")
//                        .url("https://springshop.wiki.github.org/docs"));
//    }
    @Bean
    public GroupedOpenApi singerApi() {
        return GroupedOpenApi.builder()
                .group("歌手模块")
                .pathsToMatch("/singer/**")
                .build();
    }
    @Bean
    public GroupedOpenApi albumApi() {
        return GroupedOpenApi.builder()
                .group("专辑模块")
                .pathsToMatch("/album/**")
                .build();
    }
    @Bean
    public GroupedOpenApi musicApi() {
        return GroupedOpenApi.builder()
                .group("音乐模块")
                .pathsToMatch("/music/**")
                .build();
    }
    @Bean
    public GroupedOpenApi playlistApi() {
        return GroupedOpenApi.builder()
                .group("歌单模块")
                .pathsToMatch("/playlist/**")
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

}
