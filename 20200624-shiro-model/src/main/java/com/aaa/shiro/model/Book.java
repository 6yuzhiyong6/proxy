package com.aaa.shiro.model;


import java.io.Serializable;

public class Book implements Serializable {

    private Long id;


    private String bookName;


    private Double bookPrice;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return book_name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName
     */
    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    /**
     * @return book_price
     */
    public Double getBookPrice() {
        return bookPrice;
    }

    /**
     * @param bookPrice
     */
    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }
}