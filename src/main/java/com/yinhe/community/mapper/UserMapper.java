package com.yinhe.community.mapper;

import com.yinhe.community.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author 张旭
 * @create 2021-02-21 15:25
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(account_id,name,token,gmt_create,gmt_modified,avatar_url) values (#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findbytoken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

}
