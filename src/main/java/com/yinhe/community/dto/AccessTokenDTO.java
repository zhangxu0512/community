package com.yinhe.community.dto;

/**
 * @author 张旭
 * @create 2021-02-18 14:33
 */
public class AccessTokenDTO {
    private String client_id;
    private String client_secent;
    private String code;
    private String redirect_uri;
    private String state;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secent() {
        return client_secent;
    }

    public void setClient_secent(String client_secent) {
        this.client_secent = client_secent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
