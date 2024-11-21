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

@WebServlet("/addstudent")
public class AddstudentServlet extends HttpServlet {

    BookService service;


    @Override
    public void init() throws ServletException {
        service =new com.book.Service.impl.BookService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Thymeleaf.process("addstudent.html",new Context(), resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");//没大写
        String gender=req.getParameter("gender");
        int age=Integer.parseInt(req.getParameter("age"));
        service.addStudent(name,gender,age);
        resp.sendRedirect("students");
    }
}
