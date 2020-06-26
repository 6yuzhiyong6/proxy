package com.aaa.shiro.service;

import com.aaa.shiro.mapper.BookMapper;
import com.aaa.shiro.model.Book;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.Yu
 * @Date: 2020/6/24 15:06
 * @description
 * @Version 1.0
 */
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;
    /**
     * @author  Mr.Yu
     * @message 不在云端起舞，紧贴地面行走
     * @description
     *      查询所有的图书信息
     * @param
     * @return
     */
    public Map<String, Object> selectAllBooks(){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Book> bookList = bookMapper.selectAllBooks();
        if (bookList.size() > 0){
            resultMap.put("code", "200");
            resultMap.put("data", bookList);
        }else {
            resultMap.put("code", "400");
            resultMap.put("msg", "暂时没有图书！");
        }
        return resultMap;
    }

    /**
     * @author  Mr.Yu
     * @message 不在云端起舞，紧贴地面行走
     * @description
     *      新增书本
     * @param
     * @return
     */
    @RequiresPermissions("book:insert")
    public String addBook(Book book){
        return null;
    }
}

