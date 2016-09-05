package com.ztw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by zsl-pc on 2016/8/30.
 */
@SpringBootApplication
@EnableEurekaServer
public class RootApplication {

    public static void main(String [] args) {
        
        SpringApplication.run(RootApplication.class ,args);
    }
}
