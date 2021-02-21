package com.yinhe.community.mapper;

import com.yinhe.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 张旭
 * @create 2021-02-21 15:25
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(account_id,name,token,gmt_create,gmt_modified) values (#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified})")
    void insert(User user);
}
