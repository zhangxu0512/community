package com.yinhe.community.controller;

import com.yinhe.community.dto.PaginationDTO;
import com.yinhe.community.dto.QuestionDTO;
import com.yinhe.community.mapper.QuestionMapper;
import com.yinhe.community.mapper.UserMapper;
import com.yinhe.community.model.Question;
import com.yinhe.community.model.User;
import com.yinhe.community.service.QuestionService;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 张旭
 * @create 2021-02-14 15:05
 */
@Controller
public class indexController {


    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {

        PaginationDTO pagination = questionService.list(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
