package com.java.mynotebooknotebook.mapper;

import com.java.mynotebooknotebook.entity.NoteBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

@Mapper
public interface NoteBookMapper {

    @Select({"select id,word,meaning,sentence,notes,createTime from notebook"})
    List<NoteBook> getList();

    @Select({"select id,word,meaning,sentence,notes,createTime from notebook where word = #{word}"})
    List<NoteBook> queryNoteBooks(String word);

    @UpdateProvider(value = NoteBookSqlProvider.class, method = "addNoteBook")
    int addNoteBook(NoteBook noteBook);

    @UpdateProvider(value = NoteBookSqlProvider.class, method = "batchInsert")
    void batchInsert(List<NoteBook> list);

    @UpdateProvider(value = NoteBookSqlProvider.class, method = "delNoteBook")
    int delNoteBook(List<Integer> ids);

    @UpdateProvider(value = NoteBookSqlProvider.class, method = "updateNoteBook")
    int updateNoteBook(NoteBook noteBook);
}
