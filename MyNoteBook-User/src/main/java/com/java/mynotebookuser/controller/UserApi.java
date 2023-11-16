package com.java.mynotebookuser.controller;


import com.java.mynotebookuser.entity.User;
import com.java.mynotebookuser.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserApi {
    Result login(User inputUser);

    Result register(User inputUser);

    @GetMapping("/user/getList")
    Result getList();

    @GetMapping("/getNoteBookList")
    Result getNoteBookList();
}
