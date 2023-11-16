package com.java.mynotebooknotebook.mapper;

import com.java.mynotebooknotebook.entity.NoteBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

@Mapper
public interface NoteBookMapper {

    @UpdateProvider(value = NoteBookSqlProvider.class, method = "updateNoteBook")
    int updateNoteBook(NoteBook noteBook);

    @Select({"select id,word,meaning,sentence,notes,createTime from notebook"})
    List<NoteBook> getList();

    int addNoteBook(NoteBook noteBook);

    int delNoteBook(List<Integer> ids);

    @Select({"select id,word,meaning,sentence,notes,createTime from notebook where words = #{word} or meanging like __#{word}%}"})
    List<NoteBook> queryNoteBooks(String word);

    void batchInsert(List<NoteBook> list);

}
