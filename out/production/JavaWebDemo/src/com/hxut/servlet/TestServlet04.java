package com.hxut.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet04",urlPatterns = "/testServlet04")
public class TestServlet04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1.获取ServletContext对象
        ServletContext context =this.getServletContext();
        // 2获取Web应用参数名称对应的值
       String param1= context.getInitParameter("copyRight");
        String param2= context.getInitParameter("className");
        // 3.将值输出
        PrintWriter out = resp.getWriter();
        out.println("copyRight="+param1);
        out.println("className="+param2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
