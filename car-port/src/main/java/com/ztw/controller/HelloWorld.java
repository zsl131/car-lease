package com.ztw.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2016/9/4.
 */
@RestController
public class HelloWorld {
    @RequestMapping("/")
    public String home(){
        return "hello!mr zhang";
    }
}
