package com.java.mynotebookuser.mapper;

import com.java.mynotebookuser.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> getList();


    int addUser(User inputUser);

    User login(User inputUser);

    int delete(User inputUser);

    int batchDelete(User inputUser);

    int update(User inputUser);

}
