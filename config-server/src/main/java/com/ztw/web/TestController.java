package com.ztw.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zsl-pc on 2016/9/4.
 */
@RestController
public class TestController {

    @Value("${myVal}")
    private String myVal;

    @RequestMapping(value="index")
    public String index() {
        return myVal;
    }
}
