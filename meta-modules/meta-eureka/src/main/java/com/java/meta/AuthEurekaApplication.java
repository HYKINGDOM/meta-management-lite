package com.java.meta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AuthEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthEurekaApplication.class, args);
    }

}
