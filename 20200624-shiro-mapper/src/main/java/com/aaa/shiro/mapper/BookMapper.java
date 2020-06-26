package com.aaa.shiro.mapper;


import com.aaa.shiro.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    /**
     *查询所有的书本信息
     */
    List<Book> selectAllBooks();
}