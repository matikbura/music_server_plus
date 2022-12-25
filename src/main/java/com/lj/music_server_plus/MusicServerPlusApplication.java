package com.lj.music_server_plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class MusicServerPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MusicServerPlusApplication.class, args);
    }

}
