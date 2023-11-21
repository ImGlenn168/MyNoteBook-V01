package com.java.mynotebookwriting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Writing {
    private int id;
    private String title;
    private String author;
    private String content;
    private String createTime;

    public Writing(String title, String author, String content, String createTime) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.createTime = createTime;
    }
}
