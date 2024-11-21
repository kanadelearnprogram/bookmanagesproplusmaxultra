package com.book.servlet;

import com.book.Service.BookService;

import com.book.Service.StudentService;
import com.book.utils.Thymeleaf;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/addborrow")
public class AddBorrowServlet extends HttpServlet {
    BookService service;


    @Override
    public void init() throws ServletException {
        service =new com.book.Service.impl.BookService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        context.setVariable("booklist",service.getBookList());
       // context.setVariable("booklist",service.getActiveBookList());
        context.setVariable("studentlist",service.getStudentList());
        Thymeleaf.process("addborrow.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int book = Integer.parseInt(req.getParameter("book")) ;
        int student = Integer.parseInt(req.getParameter("student")) ;
        service.addBorrow(student,book);
        resp.sendRedirect("index");
    }
}
