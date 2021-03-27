package com.yinhe.community.controller;

import com.yinhe.community.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 张旭
 * @create 2021-02-22 17:11
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(User user) {
        return "login";
    }
}
