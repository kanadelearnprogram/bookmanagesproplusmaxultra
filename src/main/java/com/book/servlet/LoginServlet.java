package com.book.servlet;

import com.book.Service.impl.UserService;
import com.book.utils.Thymeleaf;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
/**
 * @author kumiko
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService service;
    @Override
    public void init() throws ServletException {
        service =new UserService();
    }
/*
*doGet为展示
* doPost为发送请求
*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Context context= new Context();
      if (req.getSession().getAttribute("login-failure")!=null){
          context.setVariable("failure",true);
          req.getSession().removeAttribute("login-failure");
      }

        Thymeleaf.process("login.html",new Context(),resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String  username=req.getParameter("Username");
    String  password=req.getParameter("Password");
    if (service.auth(username,password,req.getSession())){
        if (req.getSession().getAttribute("user")!=null){
            resp.sendRedirect("index");
        }
    }else {
        req.getSession().setAttribute("login-failure",new Object());
        this.doGet(req,resp);
    }
     }
    }
