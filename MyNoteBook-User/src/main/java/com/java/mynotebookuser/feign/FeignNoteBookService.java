package com.java.mynotebookuser.feign;

import com.java.mynotebookuser.entity.FeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "mynotebook-book", url = "http://localhost:8002")
public interface FeignNoteBookService {
    @GetMapping("/notebook/getList")
    FeignResponse getNoteBookList();

}
