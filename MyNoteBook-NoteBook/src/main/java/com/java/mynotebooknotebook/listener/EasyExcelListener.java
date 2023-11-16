package com.java.mynotebooknotebook.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.java.mynotebooknotebook.entity.NoteBook;
import com.java.mynotebooknotebook.service.NoteBookService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EasyExcelListener extends AnalysisEventListener<NoteBook> {

    @Autowired
    private NoteBookService noteBookService;

    private int GENERAL_ONCE_SAVE_TO_DB_ROWS = 10000;

    private int i = 1;

    // 用于存储读取的数据
    private List<NoteBook> list = new ArrayList<>();

    public EasyExcelListener(NoteBookService noteBookService) {
        this.noteBookService = noteBookService;
    }


    @Override
    public void invoke(NoteBook noteBook, AnalysisContext analysisContext) {
        list.add(noteBook);
        if (list.size() == GENERAL_ONCE_SAVE_TO_DB_ROWS) {
            noteBookService.batchInsert(list);
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 处理剩余的数据
        if (!CollectionUtils.isEmpty(list)) {
            noteBookService.batchInsert(list);
        }
    }
}
