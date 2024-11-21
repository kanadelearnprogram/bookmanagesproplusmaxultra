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

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    BookService service;


    @Override
    public void init() throws ServletException {
        service =new com.book.Service.impl.BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context =new Context();
        context.setVariable("booklist",service.getBookList());
        Thymeleaf.process("book.html", context,resp.getWriter());
    }
}
