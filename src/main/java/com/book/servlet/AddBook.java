package com.book.servlet;

import com.book.Service.BookService;
import com.book.utils.Thymeleaf;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.io.Writer;
@WebServlet("/addbook")
public class AddBook extends HttpServlet {
    BookService service;


    @Override
    public void init() throws ServletException {
        service =new com.book.Service.impl.BookService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Thymeleaf.process("addbook.html",new Context(), resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String bookName=req.getParameter("bookName");//没大写
        String des=req.getParameter("des");
        int price=Integer.parseInt(req.getParameter("price"));
        service.addBook(bookName,des,price);
        resp.sendRedirect("books");
    }
}
