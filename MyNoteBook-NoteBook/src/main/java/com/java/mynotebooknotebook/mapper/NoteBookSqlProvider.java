package com.java.mynotebooknotebook.mapper;

import com.java.mynotebooknotebook.entity.NoteBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mapper
public class NoteBookSqlProvider {

    private String sql;

    public String addNoteBook(NoteBook noteBook) {
        sql = "insert into notebook(`word`, `meaning`, `sentence`, `notes`) values(" +
                "\'" + noteBook.getWord() + "\', " +
                "\'" + noteBook.getMeaning() + "\', " +
                "\'" + noteBook.getSentence() + "\', " +
                "\'" + Optional.of(noteBook.getNotes()).orElse("") + "\'" +
                ");";
        return sql;
    }


    public String batchInsert(List<NoteBook> list) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("insert into notebook(`word`, `meaning`, `sentence`, `notes`) values");
        for (NoteBook noteBook : list) {
            buffer.append("( \'" + noteBook.getWord() + "\', \'" + noteBook.getMeaning() + "\', \'" +
                    noteBook.getSentence() + "\', \'" + noteBook.getNotes() + "\' ),");
        }
        String sql = buffer.toString().substring(0, buffer.toString().length() - 1) + "; ";
        System.out.println(sql);
        return sql;
    }

    public String delNoteBook(List<Integer> ids) {
        //?为占位符
        StringBuilder sql = new StringBuilder();
        sql.append("delete from notebook where id in (");
        for (Integer id : ids) {
            sql.append(id + ",");
        }
        sql.deleteCharAt(sql.toString().length() - 1);
        sql.append("); ");
        return sql.toString();
    }

    public String updateNoteBook(NoteBook noteBook) {
        sql = "update notebook set word= \'" + noteBook.getWord() + "\', " +
                "meaning= \'" + noteBook.getMeaning() + "\', " +
                "sentence= \'" + noteBook.getSentence() + "\', " +
                "notes= \'" + Optional.of(noteBook.getNotes()).orElse("") + "\' " +
                "where id= \'" + noteBook.getId() + "\'" +
                ";";
        return sql;
    }


//    public static void main(String[] args) {
//        NoteBookSqlProvider noteBookSqlProvider = new NoteBookSqlProvider();
//        String s = noteBookSqlProvider.updateNoteBook(new NoteBook("AAA", "AAA", "AAA", "AAA"));
//        System.out.println(s);
//    }

//    public static void main(String[] args) {
//        NoteBookSqlProvider noteBookSqlProvider = new NoteBookSqlProvider();
//        List<Integer> ids = new ArrayList<>();
//        ids.add(1);
//        ids.add(2);
//        ids.add(3);
//        String s = noteBookSqlProvider.delNoteBook(ids);
//        System.out.println(s);
//    }

//    public static void main(String[] args) {
//        NoteBookSqlProvider noteBookSqlProvider = new NoteBookSqlProvider();
//        String s = noteBookSqlProvider.addNoteBook(new NoteBook("AAA", "AAA", "AAA", "AAA"));
//        System.out.println(s);
//    }

//    public static void main(String[] args) {
//        NoteBookSqlProvider noteBookSqlProvider = new NoteBookSqlProvider();
//        ArrayList<NoteBook> noteBooks = new ArrayList<>();
//        noteBooks.add(new NoteBook("AAA", "AAA", "AAA", "AAA"));
//        noteBooks.add(new NoteBook("BBB", "BBB", "BBB", "BBB"));
//        noteBooks.add(new NoteBook("CCC", "CCC", "CCC", "CCC"));
//        noteBooks.add(new NoteBook("DDD", "DDD", "DDD", "DDD"));
//        noteBookSqlProvider.batchInsert(noteBooks);
//    }
}
