package com.example.bookstore.domain;

/**
 * @author victor
 * @date 2019-07-05
 */

import javax.persistence.*;

/**
 * Book 实体类
 *
 */
@Entity
public class Book {

    /**
     * 书的编号
     */
    @Id  // 设置id 为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 自增长策略
    private Long id;

    /**
     * 书名
     */
    @Column(nullable = false)  // 不能为空
    private String bookname;

    /**
     * 作者
     */
    @Column(nullable = false)
    private String writer;

    /**
     * 简介
     */
    @Column(nullable = false)
    private String introduction;

    // 创建无参和 传参构造函数

    public Book() {
    }

    public Book(String bookname, String writer, String introduction) {
        this.id = id;
        this.bookname = bookname;
        this.writer = writer;
        this.introduction = introduction;
    }

    // 创建 getter 和 setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", writer='" + writer + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}

