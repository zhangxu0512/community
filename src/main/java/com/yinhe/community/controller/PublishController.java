package com.yinhe.community.controller;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;
import com.yinhe.community.mapper.QuestionMapper;
import com.yinhe.community.mapper.UserMapper;
import com.yinhe.community.model.Question;
import com.yinhe.community.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.awt.SunHints;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 张旭
 * @create 2021-02-22 15:31
 */
@Controller
public class PublishController {


    @Autowired
    private QuestionMapper questionMapper;


    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam(value = "title", required = false) String title,
                            @RequestParam(value = "description", required = false) String description,
                            @RequestParam(value = "tag", required = false) String tag,
                            HttpServletRequest request,
                            HttpSession session,
                            Model model) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }
        Question question = new Question();
        User user =(User)request.getSession().getAttribute("user");

        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.create(question);
        return "redirect:/";
    }
}
