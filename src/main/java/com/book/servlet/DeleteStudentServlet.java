package com.book.servlet;

import com.book.Service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/delete-student")
public class DeleteStudentServlet extends HttpServlet {
    BookService service;

    @Override
    public void init() throws ServletException {
        service =new com.book.Service.impl.BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid =Integer.parseInt(req.getParameter("sid"));
        service.deleteStudent(sid);
        resp.sendRedirect("students");
    }
}
