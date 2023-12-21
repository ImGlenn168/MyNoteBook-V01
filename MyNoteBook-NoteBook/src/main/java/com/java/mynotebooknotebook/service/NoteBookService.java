package com.java.mynotebooknotebook.service;

import com.alibaba.excel.EasyExcel;
import com.java.mynotebooknotebook.entity.NoteBook;
import com.java.mynotebooknotebook.mapper.NoteBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteBookService {

    @Autowired
    private NoteBookMapper noteBookMapper;

    public int updateNoteBook(NoteBook noteBook) {
        Integer x = checkNoteBook(noteBook);
        if (x != null) return x;
        return noteBookMapper.updateNoteBook(noteBook);
    }

    public List<NoteBook> getList() {
        List<NoteBook> list = noteBookMapper.getList();
        if (list.size() > 0) {
            return list;
        } else {
            return new ArrayList<>();
        }
    }

    public int addNoteBook(NoteBook noteBook) {
        Integer x = checkNoteBook(noteBook);
        if (x != null) return x;
        return noteBookMapper.addNoteBook(noteBook);
    }

    public int delNoteBook(List<Integer> ids) {
        return noteBookMapper.delNoteBook(ids);
    }

    public List<NoteBook> queryNoteBooks(String word) {
        if ("".equals(word) || word == null) {
            return getList();
        }
        return noteBookMapper.queryNoteBooks(word);
    }

    public List<NoteBook> queryNoteBooksById(int id) {
        if (id == 0) {
            return getList();
        }
        return noteBookMapper.queryNoteBooksById(id);
    }

    private Integer checkNoteBook(NoteBook noteBook) {
        if ("".equals(noteBook.getWord()) || noteBook.getWord() == null) {
            return -1;
        }
        if ("".equals(noteBook.getMeaning()) || noteBook.getMeaning() == null) {
            return -1;
        }
        if ("".equals(noteBook.getSentence()) || noteBook.getSentence() == null) {
            return -1;
        }
        return null;
    }

    public boolean export(String query, String filePath, String fileName) {
        if ("".equals(filePath) || filePath == null
                || "".equals(fileName) || fileName == null) {
            return false;
        }
        int count = 0;
        //1、创建一个文件对象
        File excelFile = new File(filePath + "\\" + fileName + ".xlsx");
        //2、判断文件是否存在，不存在则创建一个Excel文件
        if (!excelFile.exists()) {
            try {
                excelFile.createNewFile();//创建一个新的文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if ("".equals(query) || query == null) {
            //3、指定需要那个class去写。然后写到第一个sheet，名字为模版，然后文件流会自动关闭
            List<NoteBook> list = getList();
            count = list.size();
            EasyExcel.write(excelFile, NoteBook.class).sheet("notebook").doWrite(list);
        } else {
            List<NoteBook> noteBooks = noteBookMapper.queryNoteBooks(query);
            count = noteBooks.size();
            EasyExcel.write(excelFile, NoteBook.class).sheet("queryNotebook").doWrite(noteBooks);
        }
        System.out.println("文件已存入" + filePath + "\\" + fileName + ".xlsx");
        return count > 0;
    }

    public void batchInsert(List<NoteBook> list) {
        noteBookMapper.batchInsert(list);
    }
}
