package com.example.myblog.controller;

import com.example.myblog.domain.User;
import com.example.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



import java.util.ArrayList;
import java.util.List;

/**
 * @author victor
 * @date 2019-07-04
 */


@RestController
@RequestMapping("/users")
public class UserController {

    // 自动注入对像
    @Autowired
    private UserRepository userRepository;

    // 获取用户列表
    private List<User> getUserlist() {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    // 查询所有用户
    @GetMapping
    public ModelAndView list(Model model) {
//        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("userList", getUserlist());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }


    // 根据 id 查询用户
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    // 获取创建表单页面
    @GetMapping("/from")
    public ModelAndView createFrom(Model model) {
        model.addAttribute("user", new User(null,null,null,null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    // 新建用户
    @PostMapping
    public ModelAndView create(User user){
        user = userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    // 删除用户
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, Model model){
        userRepository.deleteById(id);
        model.addAttribute("userList", getUserlist());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("/users/list", "userModel", model);
    }

    // 更新用户
    @GetMapping(value = "update/{id}")
    public ModelAndView update(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).get();

        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }

}
