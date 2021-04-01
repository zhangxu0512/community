package com.yinhe.community.dto;

import lombok.Data;

/**
 * @author 张旭
 * @create 2021-03-29 21:47
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
