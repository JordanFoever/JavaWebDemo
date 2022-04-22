package com.hxut.servlet;

import com.hxut.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "LoginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //解决输出中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");
       //1.获取用户名和密码
        String username= req.getParameter("username");
        String password= req.getParameter("password");
        //2.用户名=admin，密码=123456，重定向到user_center。jsp页面
        if(username!=null&& username.equals("admin")&&  password!=null && password.equals("123456")){
            //重定向的方式实现页面的跳转
           //通过session对象传递
            HttpSession session = req.getSession();
            //模拟1个用户
            User user =new User();
            user.setName("测试");
            user.setPhone("13211111111");
            user.setAddress("武汉华夏理工学院");
            user.setUsername(username);
            user.setPassword(password);

            //通过session对象传递用户信息
            session.setAttribute("user",user);
          resp.sendRedirect(req.getContextPath()+"/user_center.jsp");
        }else {
            //3.用户名密码是其他情况，请求转发login.jsp页面
            req.setAttribute("message","用户名或者密码输入错误");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req,resp);
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
