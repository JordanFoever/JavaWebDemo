package com.hxut.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="TestServlet02",urlPatterns = "/testServlet02")
public class TestServlet02 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("初始化方法被调用");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service方法被调用");
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法被调用");
    }
}
