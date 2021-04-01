package com.yinhe.community.mapper;

import com.yinhe.community.model.Question;


public interface QuestionExtMapper {

    int incView(Question record);
    int incCommentCount(Question record);
}