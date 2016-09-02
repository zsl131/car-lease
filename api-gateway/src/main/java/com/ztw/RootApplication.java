package com.ztw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by zsl-pc on 2016/9/2.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class RootApplication {

    public static void main(String [] args) {
        SpringApplication.run(RootApplication.class, args);
    }
}
