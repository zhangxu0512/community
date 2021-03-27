package com.yinhe.community.model;

import lombok.Data;

/**
 * @author 张旭
 * @create 2021-02-21 14:40
 */
@Data
public class User {
    private Integer id;
    private String account_id;
    private String name;
    private String token;
    private long gmt_create;
    private long gmt_modified;
    private String avatarUrl;

}