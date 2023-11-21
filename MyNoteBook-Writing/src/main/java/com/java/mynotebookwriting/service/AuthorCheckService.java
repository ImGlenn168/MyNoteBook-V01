package com.java.mynotebookwriting.service;

import com.java.mynotebookwriting.entity.Writing;
import com.java.mynotebookwriting.mapper.WritingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorCheckService {

    @Autowired
    private WritingDao writingDao;

    public Writing getByAuthor(int i, String author) {
        Writing writing = null;
        if (i == 1) {
            writing = writingDao.getByAuthor(author);
        } else if (i == 2) {
            writing = writingDao.getByAuthor(author);
        } else if (i == 3) {
            writing = writingDao.getByAuthor(author);
        } else if (i == 4) {
            writing = writingDao.getByAuthor(author);
        } else if (i == 5) {
            writing = writingDao.getByAuthor(author);
        }
        return writing;
    }
}
