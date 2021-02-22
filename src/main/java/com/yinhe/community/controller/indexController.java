package com.yinhe.community.controller;

import com.yinhe.community.mapper.UserMapper;
import com.yinhe.community.model.User;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 张旭
 * @create 2021-02-14 15:05
 */
@Controller
public class indexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                String token= cookie.getValue();
                User user= userMapper.findbytoken(token);
                if(user !=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }


        return "index";
    }
}
