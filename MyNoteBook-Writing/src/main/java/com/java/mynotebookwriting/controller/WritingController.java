package com.java.mynotebookwriting.controller;


import com.java.mynotebookwriting.service.WritingService;
import com.java.mynotebookwriting.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WritingController {

    @Autowired
    private WritingService writingService;

    @GetMapping("/writing/send")
    public Result sendMessage() throws Exception {
        String message = writingService.sendMessage();
        return Result.success(message);
    }

    @GetMapping("/writing/receive")
    public Result receiveMessage() throws Exception {
        writingService.getMessage();
        return Result.success();
    }
}
