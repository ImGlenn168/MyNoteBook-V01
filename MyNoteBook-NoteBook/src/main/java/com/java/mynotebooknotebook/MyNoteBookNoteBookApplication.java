package com.java.mynotebooknotebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyNoteBookNoteBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyNoteBookNoteBookApplication.class, args);
    }

}
