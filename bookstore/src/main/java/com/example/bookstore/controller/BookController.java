package com.example.bookstore.controller;

/**
 * @author victor
 * @date 2019-07-05
 */

import com.example.bookstore.domain.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;


/**
 * Book 控制层
 */
@Controller
//@RequestMapping(value = "/")
public class BookController {

    /**
     * 注入 bookservice 业务层接口 的对象
     */
    @Autowired
    private BookService bookService;


    /**
     * 获取 书籍 列表
     * @param model
     * @return
     */
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping({"/", "/index"})
    public String getBookList(Model model) {
        model.addAttribute("booklist", bookService.findAll());
        model.addAttribute("title", "书籍列表");

        model.addAttribute("size", bookService.findAll().size());

        int aa ;
        aa = bookService.findAll().size();
        System.out.println(aa);

        return "bookList";
    }

    /**
     * 获取 创建 书籍页面
     *
     * @param model
     * @return
     */
//    @RequestMapping(value = "/bookcreate", method = RequestMethod.GET)
    @GetMapping({"/bookcreate"})
    public String getBookCreate(Model model){
        model.addAttribute("book", new Book(null, null, null));
        model.addAttribute("title", "添加书籍");

        return "bookForm";
    }

    /**
     * 创建 Book
     * 处理 "/bookcreate" 的 post 请求
     * @param book
     * @return
     */
//    @RequestMapping(value = "/bookcreate", method = RequestMethod.POST)
    @PostMapping({"/bookcreate"})
    public String postBook(@ModelAttribute Book book) {
        bookService.insertByBook(book);
        return "redirect:/";
    }


    /**
     *  根据 id 获取书籍详情
     * @param id
     * @param model
     * @return
     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping({"/{id}"})
    public String getBookId(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("title", "书籍详情");
        return "view";
    }

    /**
     *  获取更新 Book 表单
     * @param id
     * @param model
     * @return
     */
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    @GetMapping({"/update/{id}"})
    public String bookUpdate(@PathVariable Long id, Model model){

        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("title", "更新书籍");
        return "bookForm";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String putBook(@ModelAttribute Book book) {
//        bookService.update(book);
//        return "bookList";
//    }

    /**
     * 删除 Book
     * @param id
     * @return
     */
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @GetMapping({"/delete/{id}"})
    public String deleteBook(@PathVariable Long id){
        bookService.delete(id);
        return "redirect:/";
    }
}


