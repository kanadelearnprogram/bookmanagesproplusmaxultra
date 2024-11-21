package com.book.Service;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Student;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Borrow> getBorrowList();
    void returnBoook(String id );
    List<Book> getActiveBookList();
    List<Student> getStudentList();
    List<Book> getBookList();

    void addBorrow(int sid,int bid);
    Map<Book,Boolean> getBookMap();

    void deleteBook(int bid);

    void addBook(String bookName,String des,int price);
    void deleteStudent(int sid);

    void addStudent(String name,String gender,int age);

}
