package com.java.mynotebookwriting.mapper;

import com.java.mynotebookwriting.entity.Writing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WritingDao {

    @Select("select * from writing where author like __#{author}% ;")
    Writing getByAuthor(String author);
}
