package com.yinhe.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 张旭
 * @create 2021-02-14 11:33
 */
@Controller
public class controller {
    @GetMapping("hello")
    public String Hello(@RequestParam(name="name") String name, Model model){
        model.addAttribute("name",name);
      return "Hello";
    }
}
