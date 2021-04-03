package com.yinhe.community.dto;

import com.yinhe.community.model.User;
import lombok.Data;

/**
 * @author 张旭
 * @create 2021-03-31 17:58
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
    private  Integer commentCount;
}
