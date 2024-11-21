package com.book.entity;

import lombok.Data;

@Data
public class Borrow {
    private int id;
    private int bookId;
    private String bookName;
    private int studentId;
    private String studentName;

}
