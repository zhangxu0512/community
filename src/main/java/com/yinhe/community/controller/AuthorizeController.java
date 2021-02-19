package com.yinhe.community.controller;

import com.yinhe.community.dto.AccessTokenDTO;
import com.yinhe.community.dto.GithubUser;
import com.yinhe.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;

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
    @GetMapping("callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secent(client_secent);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        String accesstoken = githubProvider.getAccesstoken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accesstoken);
        System.out.println(user.getName());
        return "index";
    }
}
