package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author victor
 * @date 2019-07-02
 */


// 返回页面使用 Controller，RestController 返回的是接口
@Controller
public class ThymeleafController {

    @RequestMapping("/thy")
    public String test(Model model){

        // 填充数据
        model.addAttribute("title","ThymeleafController");

        // 返回 html 页面
        return "index";
    }

    // 调用类对象的元素
    @Autowired
    User user;

    // 返回页面 url
    @RequestMapping(value = "/user")
    public String getUser(Model model) {
        model.addAttribute("users",user);

        return "users";

    }

}
