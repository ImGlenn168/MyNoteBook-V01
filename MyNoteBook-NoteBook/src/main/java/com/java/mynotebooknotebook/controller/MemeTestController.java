package com.java.mynotebooknotebook.controller;

import com.java.mynotebooknotebook.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
public class MemeTestController {

    @GetMapping("/memes/getList")
    public Result getList() {
        HashMap<String, Object> memes = new HashMap<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "Drake");
        map.put("https", "https://img0.baidu.com/it/u=1524510428,2480306645&fm=253&fmt=auto&app=138&f=PNG?w=280&h=350");
        map.put("width", 1200);
        map.put("height", 1200);
        map.put("box_count", 1);
        memes.put("memes", map);
        System.out.println(memes);
        return Result.success(memes);
    }
}
