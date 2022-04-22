package com.hxut.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet03",urlPatterns = "/testServlet03",initParams = {@WebInitParam(name = "encoding",value = "UTF-8")})
public class TestServlet03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1.获取ServletConfig对象
        ServletConfig config =this.getServletConfig();
        // 2.获取参数名字为encoding对象的值，
       String param= config.getInitParameter("encoding");
        // 3 将值输出
        PrintWriter out = resp.getWriter();
        out.println("encoding="+param);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doPost(req, resp);
    }
}
