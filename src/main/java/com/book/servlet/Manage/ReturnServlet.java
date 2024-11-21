package com.book.servlet.Manage;

import com.book.Service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/return-book")
public class ReturnServlet extends HttpServlet {

    BookService service;

    @Override
    public void init() throws ServletException {
        service =new com.book.Service.impl.BookService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id= req.getParameter("id");
    service.returnBoook(id);
    resp.sendRedirect("index");
    }
}
