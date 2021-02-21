package com.yinhe.community.model;

/**
 * @author 张旭
 * @create 2021-02-21 14:40
 */
public class User {
    private Integer id;
    private String account_id;
    private String name;
    private String token;
    private long gmt_create;
    private long gmt_modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getGmt_Create() {
        return gmt_create;
    }

    public void setGmt_Create(long gmt_Create) {
        this.gmt_create = gmt_create;
    }

    public long getGmt_Modified() {
        return gmt_modified;
    }

    public void setGmt_Modified(long gmt_Modified) {
        this.gmt_modified = gmt_modified;
    }
}