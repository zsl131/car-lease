package com.ztw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by admin on 2016/9/4.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationSpring {
    public static void main(String[] args){
        SpringApplication.run(ApplicationSpring.class,args);
    }
}
