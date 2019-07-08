package com.example.bookstore.service;

/**
 * @author victor
 * @date 2019-07-05
 */

import com.example.bookstore.domain.Book;

import java.util.List;

/**
 * 业务层接口
 */
public interface BookService {

    /**
     * 获取所有 Book
     * @return
     */
    List<Book> findAll();

    /**
     * 新增 Book
     * @param book
     * @return
     */
    Book insertByBook(Book book);

    /**
     * 更新 Book
     * @param book
     * @return
     */
    Book update(Book book);

    /**
     * 删除 Book
     * @param id
     * @return
     */
    Book delete(Long id);

    /**
     * 获取 Book 详情，根据 id
     * @param id
     * @return
     */
    Book findById(Long id);

    /**
     * 获取 Book 详情，根据 bookname
     * @param bookname
     * @return
     */
    Book findByBookname(String bookname);

    /**
     * 新增方法 根据 bookname 和 writer 查询
     * @param bookname
     * @param writer
     * @return
     */
    Book findByBooknameAndWriter(String bookname, String writer);

}
