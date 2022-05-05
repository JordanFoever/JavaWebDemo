package com.hxut.servlet;

import com.hxut.dao.UserDao;
import com.hxut.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
        //2.从数据库中查询
        UserDao userDao = new UserDao();
        User user = userDao.findUserByNameAndPs(username, password);

        // 记住密码的实现
        String remebers = req.getParameter("remebers");

        if(remebers != null && remebers.equals("true")){
            Cookie cookie1 = new Cookie("username", username);
            Cookie cookie2 = new Cookie("password", password);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
        }

        if(user!=null&&user.getUsername()!=null){
            //重定向的方式实现页面的跳转
           //通过session对象传递
            HttpSession session = req.getSession();

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
