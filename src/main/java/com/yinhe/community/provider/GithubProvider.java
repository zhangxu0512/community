package com.yinhe.community.provider;

import com.alibaba.fastjson.JSON;
import com.yinhe.community.dto.AccessTokenDTO;
import com.yinhe.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;
import sun.applet.Main;

import java.io.IOException;

/**
 * @author 张旭
 * @create 2021-02-18 14:26
 */
@Component
public class GithubProvider {
    public String getAccesstoken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token?client_id=" + accessTokenDTO.getClient_id() + "&client_secret=" + accessTokenDTO.getClient_secent() + "&code=" + accessTokenDTO.getCode() + "&redirect_uri=" + accessTokenDTO.getRedirect_uri() + "&state=" + accessTokenDTO.getState())
                .post(body)
                .build();
        try {
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                String token = string.split("&")[0].split("=")[1];

                return token;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization", "token " + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
