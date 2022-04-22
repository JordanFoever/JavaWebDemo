package com.hxut.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "FirstServlet",urlPatterns = "/firstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //request对象传递参数
        req.setAttribute("name1","Java 语言程序设计");
        //sessson对象传递参数
        //获取session对象
        HttpSession session=req.getSession();
        session.setAttribute("name2","Java Web应用开发");
        //application对象传递参数
        //获取application对象
        ServletContext application =req.getServletContext();
        application.setAttribute("name3","Java EE 企业级开发框架");
        //请求转发到show.jsp页面
        RequestDispatcher dispatcher =req.getRequestDispatcher("jsp/show.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
