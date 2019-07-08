package com.example.myblog.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author victor
 * @date 2019-07-04
 */


// 创建一个实体类

@Entity
@XmlRootElement // mediatype 转为 xml
public class User {
    @Id  // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 自增长策略
    private Long id;

    @Column(nullable = false) // 映射字段值不能为空
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    // 创建无参和 传参构造函数
    protected User() {} // // JPA 的规范要求无参构造函数；设为 protected 防止直接使用


    public User(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    // 创建setter、getter 方法
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
