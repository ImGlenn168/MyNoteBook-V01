package com.java.mynotebookwriting.controller;


import com.java.mynotebookwriting.entity.Writing;
import com.java.mynotebookwriting.service.WritingService;
import com.java.mynotebookwriting.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("writing")
public class WritingController {

    @Autowired
    private WritingService writingService;

    @GetMapping("/mq/send")
    public Result sendMessage() throws Exception {
        String message = writingService.sendMessage();
        return Result.success(message);
    }

    @GetMapping("/mq/receive")
    public Result receiveMessage() throws Exception {
        writingService.getMessage();
        return Result.success();
    }

    @GetMapping("/getByAuthor/{author}")
    public Result getByAuthor(@PathVariable("author") String author) throws Exception {
        try {
            Writing byAuthor = writingService.getByAuthor(author);
            return Result.success(byAuthor);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("系统异常.....");
        }
        return Result.fail();
    }
}
