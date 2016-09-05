package com.ztw.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

/**
 * Created by zsl-pc on 2016/9/4.
 */
@Controller
@RequestMapping(value="test")
public class TestController {

    @RequestMapping(value="index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "index";
    }

}
