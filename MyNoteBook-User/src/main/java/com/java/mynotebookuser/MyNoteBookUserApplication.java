package com.java.mynotebookuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.java.mynotebookuser.feign"})
//@EnableEurekaClient
@MapperScan(basePackages = "com.java.mynotebookuser.mapper")
public class MyNoteBookUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyNoteBookUserApplication.class, args);
    }

}
