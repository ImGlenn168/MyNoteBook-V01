package com.java.mynotebooknotebook.mapper;

import com.java.mynotebooknotebook.entity.NoteBook;
import org.apache.ibatis.annotations.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Mapper
public class NoteBookSqlProvider {

    private int i;

    public int addNoteBook(NoteBook noteBook) {

        return i;
    }

    public String updateNoteBook(NoteBook noteBook) {
        return "";
    }

    public int delNoteBook(List<Integer> ids) {

        return i;
    }

    public List<NoteBook> queryNoteBooks(String word) {
        List<NoteBook> noteBooks = new ArrayList<>();

        return noteBooks;
    }

    private void addNoteBookList(List<NoteBook> customers, ResultSet rs) throws SQLException {
        NoteBook noteBook = new NoteBook();
        noteBook.setId(rs.getString("id"));
        noteBook.setWord(rs.getString("word"));
        noteBook.setMeaning(rs.getString("meaning"));
        noteBook.setSentence(rs.getString("sentence"));
        noteBook.setNotes(rs.getString("notes"));
        noteBook.setCreateTime(rs.getString("createTime"));
        customers.add(noteBook);
    }

    public void batchInsert(List<NoteBook> list) {

    }
}
