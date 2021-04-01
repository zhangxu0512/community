package com.yinhe.community.dto;

import com.yinhe.community.model.User;
import lombok.Data;

/**
 * @author 张旭
 * @create 2021-02-28 12:47
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
