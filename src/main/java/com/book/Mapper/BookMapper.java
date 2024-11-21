package com.book.Mapper;

import com.book.entity.Book;
import com.book.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    @Results({

            @Result(column = "id",property = "id"),
            @Result(column = "bid",property = "bookId"),
            @Result(column = "bookName",property = "bookName"),
            @Result(column = "sid",property = "studentId"),
            @Result(column = "name",property = "studentName")

    })
    @Select("select * from borrow ,student , book where borrow.bid=book.bid and borrow.sid=student.sid")
    List<Borrow> getBorrowList();
    @Delete("delete from borrow where id=#{id}")
    void deleteBor(String id);

    @Insert("insert into borrow(sid, bid) values (#{sid},#{bid})")
    void addBorrow(@Param("sid") int sid,@Param("bid") int bid);
    @Select("select * from book")
    List<Book> getBookList();

    @Delete("delete from book where bid =#{bid}")
    void deleteBook(int bid);
    @Insert("insert into book(bookName,des,price) values (#{bookName},#{des},#{price})")
    void addBook(@Param("bookName") String bookName,@Param("des") String des,@Param("price") int price);
    @Delete("delete from student where sid =#{sid}")//删错了
    void deleteStudent(int sid);
    @Insert("insert into student(name, gender, age) values (#{name},#{gender},#{age})")
    void addStudent(@Param("name") String name,@Param("gender") String gender,@Param("age") int age);
}
