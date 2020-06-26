package com.aaa.shiro.controller;

import com.aaa.shiro.model.Book;
import com.aaa.shiro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Yu
 * @Date: 2020/6/24 15:01
 * @description
 * @Version 1.0
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * @author  Mr.Yu
     * @message 不在云端起舞，紧贴地面行走
     * @description
     *       ModelMap
     *       Model
     *       ModelAndView
     *       都能返回数据
     *       Model和ModelAndView返回的数据格式就是常规格式
     *       ModelMap:
     *       会把返回的常规格式转换为key:value类型
     * @param
     * @return
     */
    @RequestMapping("/allBooks")
    public String turnBookPage(ModelMap modelMap){
        // 需要从数据库中把所有的图书信息查询并返回到页面上
        Map<String, Object> resultMap = bookService.selectAllBooks();
        // 可以做判断-->以后还是不能(全是ajax)
        if ("200".equals((String) resultMap.get("code")) && null != resultMap.get("data")){
            modelMap.addAttribute("bookList", (List<Book>) resultMap.get("data"));
            return "book_index";
        }
        return "error";
    }

    @RequestMapping("/addBook")
    public String add(){
        Book book = new Book();
        bookService.addBook(book);
        return "";
    }
}

