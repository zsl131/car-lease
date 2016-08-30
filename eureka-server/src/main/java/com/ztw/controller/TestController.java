package com.ztw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zsl-pc on 2016/8/30.
 */
@RestController
public class TestController {

    @RequestMapping(value="index")
    public String index() {
        return "大家好";
    }
}
