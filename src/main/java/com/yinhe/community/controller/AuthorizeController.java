package com.yinhe.community.controller;

import com.yinhe.community.dto.AccessTokenDTO;
import com.yinhe.community.dto.GithubUser;
import com.yinhe.community.mapper.UserMapper;
import com.yinhe.community.model.User;
import com.yinhe.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
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
                           @RequestParam(name = "state") String state,
//                           HttpServletRequest request,
                           HttpServletResponse response
    ) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secent(client_secent);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        String accesstoken = githubProvider.getAccesstoken(accessTokenDTO);
        GithubUser githubuser = githubProvider.getUser(accesstoken);
        if (githubuser != null) {
            User user = new User();
            user.setAccount_id(String.valueOf(githubuser.getId()));
            user.setName(githubuser.getName());
            String token = UUID.randomUUID().toString();
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modified(user.getGmt_create());
            user.setToken(token);
            user.setAvatarUrl(githubuser.getAvatar_url());
            userMapper.insert(user);

            //登陆成功 写cookie和session
            response.addCookie(new Cookie("token", token));
//            request.getSession().setAttribute("user",githubuser);
            return "redirect:/";
        } else {
            //登陆失败  重新登陆
            return "redirect:/";
        }

    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        response.addCookie(cookie);
        return "redirect:/";
    }

}
