package com.yinhe.community.dto;

import lombok.Data;

/**
 * @author 张旭
 * @create 2021-02-18 14:33
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secent;
    private String code;
    private String redirect_uri;
    private String state;


}
