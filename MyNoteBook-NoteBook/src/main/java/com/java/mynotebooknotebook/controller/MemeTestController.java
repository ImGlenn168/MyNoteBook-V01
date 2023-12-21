package com.java.mynotebooknotebook.controller;

import com.java.mynotebooknotebook.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@Slf4j
public class MemeTestController {

    @GetMapping("/memes/getList")
    public Result getList() {
        HashMap<String, Object> memes = new HashMap<>();
        HashMap<String, Object> map1 = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        ArrayList<HashMap> list = new ArrayList<>();
        map1.put("id", 1);
        map1.put("name", "Drake");
        map1.put("url", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2Fb1a914be-4e3d-47ca-9406-780e9530aa9c%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1705746402&t=1fce3b2a8ae6ad843d4c1353ce86a0c0");
        map1.put("width", 1200);
        map1.put("height", 1200);
        map1.put("box_count", 1);

        map2.put("id", 2);
        map2.put("name", "Luke");
        map2.put("url", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2F12f18496-3075-4367-b599-ae390f0e0b37%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1705746269&t=990a2d183aea29d07f93bc97868bd155");
        map2.put("width", 1200);
        map2.put("height", 1200);
        map2.put("box_count", 2);

        list.add(map1);
        list.add(map2);
        memes.put("memes", list);
        System.out.println(memes);
        return Result.success(memes);
    }
}
