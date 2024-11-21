package com.book.servlet;

import com.book.Service.BookService;
import com.book.entity.User;
import com.book.utils.Thymeleaf;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    BookService service;

    @Override
    public void init() throws ServletException {
        service =new com.book.Service.impl.BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Context context=new Context();
        User user =(User) req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("book_list",service.getBorrowList());
        Thymeleaf.process("index.html", context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
