package com.java.mynotebookwriting.service;

import com.alibaba.fastjson.JSON;
import com.java.mynotebookwriting.entity.Writing;
import com.java.mynotebookwriting.rabbitmq.consumer.Receiver;
import com.java.mynotebookwriting.rabbitmq.producer.Sender;
import com.java.mynotebookwriting.utils.ThreadPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Service
public class WritingService {
    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    @Autowired
    private AuthorCheckService authorCheckService;

    public String sendMessage() throws Exception {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = dateFormat.format(date);
        Writing writing = new Writing("Happy Day", "Glenn", "Today is a happy day!", currentDate);
        String jsonString = JSON.toJSONString(writing);
        sender.sendMessage(jsonString);
        return jsonString;
    }

    public void getMessage() throws Exception {
        receiver.receiveMessage();
    }

    public Writing getByAuthor(String author) {
        Writing writing = null;
        // 开启多线程
        ExecutorService fixedThreadPool = ThreadPoolUtil.getFixedThreadPool();
        List<Future<Writing>> futures = new ArrayList<>();
        try {
            for (int i = 0; i < 5; i++) {
                Future<Writing> future = fixedThreadPool.submit(new CallableTask(i + 1, author, authorCheckService));
                futures.add(future);
            }
            for (Future<Writing> future : futures) {
                while (true) {
                    if (future.isDone() && !future.isCancelled()) {
                        writing = future.get();
                        if (!ObjectUtils.isEmpty(writing)) {
                            return writing;
                        } else {
                            break;
                        }
                    } else {
                        // 每次轮询休息1毫秒（cpu纳秒级），避免cpu告诉轮询耗空
                        Thread.sleep(100);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return writing;
    }

    static class CallableTask implements Callable<Writing> {
        int i;
        String author;
        AuthorCheckService authorCheckService;

        public CallableTask(int i, String author, AuthorCheckService materialCheckService) {
            this.i = i;
            this.author = author;
            this.authorCheckService = materialCheckService;
        }

        @Override
        public Writing call() {
            return authorCheckService.getByAuthor(i, author);
        }
    }
}
