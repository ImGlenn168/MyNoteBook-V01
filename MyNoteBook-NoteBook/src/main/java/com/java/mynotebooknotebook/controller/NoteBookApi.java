package com.java.mynotebooknotebook.controller;

import com.java.mynotebooknotebook.entity.NoteBook;
import com.java.mynotebooknotebook.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.List;

public interface NoteBookApi {

    @GetMapping("/notebook/getList")
    Result getList();

    Result addNoteBook(NoteBook noteBook);

    Result updateNoteBook(NoteBook noteBook);

    Result delNoteBook(List<Integer> ids);

    Result queryNoteBooks(String word);

    Result export(String param, String filePath, String fileName);

    Result importFile(File file);
}
