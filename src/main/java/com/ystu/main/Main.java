package com.ystu.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ystu")
@EnableJpaRepositories(basePackages = "com.ystu.repositories")
@EntityScan(basePackages = "com.ystu.entities")
public class Main extends SpringBootServletInitializer {

    public static void main(String args[]) {
        SpringApplication.run(Main.class, args);
    }
}
