package com.java.mynotebookuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeignResponse {

    private int code;
    private String message;
    private Object data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class NoteBook{
        private String id;

        private String word;

        private String meaning;

        private String sentence;

        private String notes;

        private String createTime;
    }

}
