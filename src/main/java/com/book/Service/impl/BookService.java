package com.book.Service.impl;

import com.book.Mapper.BookMapper;
import com.book.Mapper.StudentMapper;
import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Student;
import com.book.utils.mybatisUti;
import org.apache.ibatis.session.SqlSession;

import java.util.*;
import java.util.stream.Collectors;

public class BookService implements com.book.Service.BookService {


    @Override
    public List<Borrow> getBorrowList() {
        try(SqlSession sqlSession = mybatisUti.getSession()){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            return mapper.getBorrowList();
        }

    }

    @Override
    public void returnBoook(String id) {
        try(SqlSession sqlSession = mybatisUti.getSession()){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
           mapper.deleteBor(id);
        }
    }

    @Override
    public List<Book> getActiveBookList() {
        return null;
    }
/*
* 不知道为啥找不到
*/
    @Override
    /*public List<Book> getActiveBookList() {

        Set<Integer> set = new HashSet<>();
        this.getBorrowList().forEach(borrow -> set.add(borrow.getBookId()));
        try(SqlSession sqlSession = mybatisUti.getSession()){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);

            return mapper.getBookList()
                    .stream()
                    .filter(book -> !set.contains(book.getBid()))
                    .collect(Collectors.toList());
        }
    }*/
    public List<Student> getStudentList() {
        try(SqlSession sqlSession = mybatisUti.getSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.getStudentList();
        }
    }

    @Override
    public List<Book> getBookList() {
        try(SqlSession sqlSession = mybatisUti.getSession()){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            return mapper.getBookList();
        }
    }

    @Override
    public void addBorrow(int sid, int bid) {
        try(SqlSession sqlSession = mybatisUti.getSession()){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
             mapper.addBorrow(sid, bid);
        }
    }

    @Override
    public Map<Book, Boolean> getBookMap() {
        Set<Integer> set = new HashSet<>();
        this.getBorrowList().forEach(borrow -> set.add(borrow.getBookId()));
        try(SqlSession sqlSession = mybatisUti.getSession()){
            Map<Book,Boolean> map =new LinkedHashMap<>();
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            mapper.getBookList().forEach(book -> {
                map.put(book,set.contains(book.getBid()));
            });
           return map;
        }
    }

    @Override
    public void deleteBook(int bid) {
        try(SqlSession sqlSession = mybatisUti.getSession()){
                BookMapper mapper = sqlSession.getMapper(BookMapper.class);
                mapper.deleteBook(bid);
            }

    }

    @Override
    public void addBook( String bookName, String des, int price) {
        try(SqlSession sqlSession = mybatisUti.getSession()){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            mapper.addBook( bookName,des,price);
        }
    }

    @Override
    public void deleteStudent(int sid) {
        try(SqlSession sqlSession = mybatisUti.getSession()){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            mapper.deleteStudent(sid);
        }
    }

    @Override
    public void addStudent(String name, String gender, int age) {

        try(SqlSession sqlSession = mybatisUti.getSession()){
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            mapper.addStudent( name,gender,age);
        }
    }


}
