package com.java.mynotebookwriting.service;

import com.alibaba.fastjson.JSON;
import com.java.mynotebookwriting.entity.Writing;
import com.java.mynotebookwriting.rabbitmq.consumer.Receiver;
import com.java.mynotebookwriting.rabbitmq.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class WritingService {
    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

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
}
