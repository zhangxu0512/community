package com.yinhe.community.mapper;

import com.yinhe.community.model.Comment;
import com.yinhe.community.model.CommentExample;
import com.yinhe.community.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}