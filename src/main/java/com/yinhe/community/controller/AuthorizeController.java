package com.yinhe.community.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.yinhe.community.dto.AccessTokenDTO;
import com.yinhe.community.dto.GithubUser;
import com.yinhe.community.mapper.UserMapper;
import com.yinhe.community.model.User;
import com.yinhe.community.provider.GithubProvider;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author 张旭
 * @create 2021-02-17 17:19
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client_id}")
    private String client_id;

    @Value("${github.client_secent}")
    private String client_secent;

    @Value("${github.redirect_uri}")
    private String redirect_uri;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state")String state,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secent(client_secent);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        String accesstoken = githubProvider.getAccesstoken(accessTokenDTO);
        GithubUser githubuser = githubProvider.getUser(accesstoken);
        if(githubuser != null){
            User user = new User();
            user.setAccount_id(String.valueOf(githubuser.getId()));
            user.setName(githubuser.getName());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setGmt_Create(System.currentTimeMillis());
            user.setGmt_Modified(user.getGmt_Create());
            userMapper.insert(user);
            //登陆成功 写cookie和session
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        }else {
           //登陆失败  重新登陆
            return "redirect:/";
        }

    }
}
