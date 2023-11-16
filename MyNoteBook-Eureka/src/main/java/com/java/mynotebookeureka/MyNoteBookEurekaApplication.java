package com.java.mynotebookeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //EnableEurekaServer 服务端的启动类，可以接受别人注册进来~
public class MyNoteBookEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyNoteBookEurekaApplication.class, args);
    }

}
