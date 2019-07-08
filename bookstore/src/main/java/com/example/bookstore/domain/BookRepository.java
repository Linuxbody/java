package com.example.bookstore.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author victor
 * @date 2019-07-05
 */

/**
 * Book 数据持久层操作接口
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * 新增方法 根据 bookname 查询
     * @param bookname
     * @return
     */
    public Book findByBookname(String bookname);

    /**
     * 新增方法 根据 bookname 和 writer 查询
     * @param bookname
     * @param writer
     * @return
     */
    public Book findByBooknameAndWriter(String bookname, String writer);

}
