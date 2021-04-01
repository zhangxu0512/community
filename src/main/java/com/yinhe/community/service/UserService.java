package com.yinhe.community.service;

import com.yinhe.community.mapper.UserMapper;
import com.yinhe.community.model.User;
import com.yinhe.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张旭
 * @create 2021-03-27 15:28
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);

        if(users.size() == 0){
          //插入
          user.setGmtCreate(System.currentTimeMillis());
          user.setGmtModified(user.getGmtCreate());
         userMapper.insert(user);
      }else{
          //更新
            User dbUser = users.get(0);
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setToken(user.getToken());
            updateUser.setName(user.getName());
            UserExample example = new UserExample();
            example.createCriteria().andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser, example);

      }

    }
}
