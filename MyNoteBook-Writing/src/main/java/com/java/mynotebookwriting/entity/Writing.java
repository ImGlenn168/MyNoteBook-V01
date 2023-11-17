package com.java.mynotebookwriting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Writing {
    private int id = 0;
    private String title;
    private String author;
    private String content;
    private String createTime;

    public Writing(String title, String author, String content, String createTime) {
        this.id++;
        this.title = title;
        this.author = author;
        this.content = content;
        this.createTime = createTime;
    }
}
