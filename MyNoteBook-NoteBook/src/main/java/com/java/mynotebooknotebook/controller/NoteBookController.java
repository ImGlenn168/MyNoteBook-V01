package com.java.mynotebooknotebook.controller;

import com.alibaba.excel.EasyExcel;
import com.java.mynotebooknotebook.entity.NoteBook;
import com.java.mynotebooknotebook.listener.EasyExcelListener;
import com.java.mynotebooknotebook.service.NoteBookService;
import com.java.mynotebooknotebook.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
public class NoteBookController implements NoteBookApi {


    @Autowired
    private NoteBookService noteBookService;

    public Result getList() {
        return Result.success(noteBookService.getList());
    }

    @Override
    public Result updateNoteBook(NoteBook noteBook) {
        return Result.getResult(noteBookService.updateNoteBook(noteBook));
    }

    @Override
    public Result addNoteBook(NoteBook noteBook) {
        return Result.getResult(noteBookService.addNoteBook(noteBook));
    }

    @Override
    public Result delNoteBook(List<Integer> ids) {
        return Result.getResult(noteBookService.delNoteBook(ids));
    }

    @Override
    public Result queryNoteBooks(String word) {
        return Result.success(noteBookService.queryNoteBooks(word));
    }

    @Override
    public Result export(String param, String path, String date) {
        return Result.success(noteBookService.export(param, path, date));
    }

    @Override
    public Result importFile(File file) {
        String fileName = file.getAbsolutePath();
        EasyExcel.read(fileName, NoteBook.class, new EasyExcelListener(noteBookService)).sheet().doRead();
        return Result.success();
    }
}
