package com.java.mynotebooknotebook.controller;

import com.alibaba.excel.EasyExcel;
import com.java.mynotebooknotebook.entity.NoteBook;
import com.java.mynotebooknotebook.listener.EasyExcelListener;
import com.java.mynotebooknotebook.service.NoteBookService;
import com.java.mynotebooknotebook.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.File;
import java.util.List;

@RestController
public class NoteBookController {

    @Autowired
    private NoteBookService noteBookService;

    @GetMapping("/notebook/getList")
    public Result getList() {
        try {
            List<NoteBook> list = noteBookService.getList();
            return Result.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统异常！");
        }
    }

    @PostMapping("/notebook/addNoteBook")
    public Result addNoteBook(@RequestBody NoteBook noteBook) {
        try {
            int i = noteBookService.addNoteBook(noteBook);
            return Result.getResult(i);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统异常！");
        }
    }

    @PostMapping("/notebook/updateNoteBook")
    public Result updateNoteBook(@RequestBody NoteBook noteBook) {
        try {
            int i = noteBookService.updateNoteBook(noteBook);
            return Result.getResult(i);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统异常！");
        }
    }

    @PostMapping("/notebook/delNoteBook")
    public Result delNoteBook(@RequestBody List<Integer> ids) {
        try {
            int i = noteBookService.delNoteBook(ids);
            return Result.getResult(i);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统异常！");
        }
    }

    @PostMapping("/notebook/queryNoteBooks/{word}")
    public Result queryNoteBooks(@PathVariable("word") String word) {
        try {
            List<NoteBook> bookList = noteBookService.queryNoteBooks(word);
            return Result.success(bookList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统异常！");
        }
    }

    @PostMapping("/notebook/export")
    public Result export(@PathParam("query") String query,
                         @PathParam("filePath") String filePath,
                         @PathParam("fileName") String fileName) {
        try {
            boolean export = noteBookService.export(query, filePath, fileName);
            return Result.success(export);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统异常！");
        }
    }

    @PostMapping("/notebook/importFile")
    public Result importFile(@RequestParam("file") File file) {
        try {
            String fileName = file.getAbsolutePath();
            EasyExcel.read(fileName, NoteBook.class, new EasyExcelListener(noteBookService)).sheet().doRead();
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("系统异常！");
        }
    }
}
