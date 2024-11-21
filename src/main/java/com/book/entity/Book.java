package com.book.entity;

import lombok.Data;

@Data
public class Book {
    private int bid;
    private String bookName;
    private String des;
    private int price;
}
