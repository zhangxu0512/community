package com.yinhe.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 张旭
 * @create 2021-02-14 15:05
 */
@Controller
public class indexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
