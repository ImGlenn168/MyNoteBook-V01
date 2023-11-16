package com.java.mynotebookuser.controller;

import com.alibaba.fastjson.JSON;
import com.java.mynotebookuser.entity.FeignResponse;
import com.java.mynotebookuser.entity.User;
import com.java.mynotebookuser.feign.FeignNoteBookService;
import com.java.mynotebookuser.service.UserService;
import com.java.mynotebookuser.utils.RedisUtil;
import com.java.mynotebookuser.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Autowired
    private FeignNoteBookService feignNoteBookService;

    @Override
    public Result login(User inputUser) {
        User login = userService.login(inputUser);
        if (login != null) {
            return Result.success(login);
        }
        return Result.fail();
    }

    @Override
    public Result register(User inputUser) {
        String jsonString = JSON.toJSONString(inputUser);
        boolean flag = new RedisUtil().set("inputUser", jsonString, 3l);
        if (flag) {
            return Result.success();
        }
        return Result.fail();
    }

    @Override
    public Result getList() {
        return userService.getList();
    }

    @Override
    public Result getNoteBookList() {
        // 先拿到feign调用的结果
        FeignResponse feignResponse = feignNoteBookService.getNoteBookList();
        // 拿到响应类中的data
        Object data = feignResponse.getData();
        // 把data转为JSONString
        String dataString = JSON.toJSONString(data);
        // 把JSONString转为目标类
        List<FeignResponse.NoteBook> list = JSON.parseObject(dataString, List.class);
        // 返回结果
        if (list.size() > 0) {
            return Result.success(list);
        }
        return Result.fail();
    }

}
