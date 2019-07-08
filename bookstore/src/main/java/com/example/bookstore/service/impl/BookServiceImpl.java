package com.example.bookstore.service.impl;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author victor
 * @date 2019-07-05
 */


/**
 * Book 业务层实现
 */
@Service
public class BookServiceImpl implements BookService {

    /**
     * 注入 BookRepository 数据持久层操作接口 的对象
     */
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book insertByBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book findByBookname(String bookname) {
        Book book = bookRepository.findByBookname(bookname);
        return book;
    }

    @Override
    public Book findByBooknameAndWriter(String bookname, String writer) {
        return null;
    }
}
