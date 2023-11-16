package com.java.mynotebookuser.service;

import com.alibaba.fastjson2.JSON;
import com.java.mynotebookuser.entity.User;
import com.java.mynotebookuser.mapper.UserDao;
import com.java.mynotebookuser.utils.RedisUtil;
import com.java.mynotebookuser.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userMapper;

    public int register(User inputUser) {
        return userMapper.addUser(inputUser);
    }

    public User login(User inputUser) {
        User login = userMapper.login(inputUser);
        if (login == null) {
            Object user = new RedisUtil().get(inputUser.getUname());
            if (user != null) {
                String jsonString = JSON.toJSONString(user);
                User userFormRedis = JSON.parseObject(jsonString, User.class);
                if (inputUser.getPassword().equals(userFormRedis.getPassword()) ||
                        inputUser.getUname().equals(userFormRedis.getUname())) {
                    return userFormRedis;
                }
                return null;
            }
            return null;
        }
        return userMapper.login(inputUser);
    }

    public Result getList() {
        List<User> list = userMapper.getList();
        return Result.success(list);
    }
}
