package com.example.demo.controller;

import com.example.demo.bean.Person;
import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author victor
 * @date 2019-07-02
 */

@RestController
public class YmlController {

    // 映射全部值
    @Autowired
    User user;

    // 取其中一个值
    @Value("${address}")
    String address;

    // 读取对象中的属性的值
    @Value("${user.lastName}")
    String lastName;

    @Autowired
    Person person;

    @RequestMapping("/yml")
    public User yamlTest() {
        return user;
    }

    @RequestMapping("/address")
    public String add(){
        return address;
    }

    @RequestMapping("/lastname")
    public String last(){
        return lastName;
    }

    @RequestMapping("/person")
    public Person person(){
        return person;
    }

    @Value("${ip}")
    String ip;
    @RequestMapping("/ip")
    public String  getip() {
        return ip;
    }


}
