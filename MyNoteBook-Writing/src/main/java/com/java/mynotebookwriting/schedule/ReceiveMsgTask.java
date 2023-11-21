package com.java.mynotebookwriting.schedule;

import com.java.mynotebookwriting.rabbitmq.consumer.Receiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class ReceiveMsgTask {

    @Autowired
    private Receiver receiver;

    @Value("${task.receive.message}")
    private String flag;

    // 每3秒执行一次
    @Scheduled(cron = "*/3 * * * * *")
    public void receiveMessages() {
        System.out.println(flag);
        if (!"true".equals(flag)) {
            return;
        }
        try {
            receiver.receiveMessage();
            System.out.println("定时任务启动........");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ReceiveMsgTask.receiveMessages()错误....");
        }
    }
}
