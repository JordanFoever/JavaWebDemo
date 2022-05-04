package com.hxut.servlet;

import com.hxut.dao.UserDao;
import com.hxut.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="RegisterServlet" ,urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //2.解决请求参数的中文乱码
        req.setCharacterEncoding("UTF-8");
        //1.获取参数名称对应的值
        //解决输出中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");

        String username= req.getParameter("username");
        String password= req.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        //3通过请求转发的方式跳转页面
        //用户名和密码为空 ，跳转注册页面，不为空，就跳转到登录页面
        if(username==null|| username.isEmpty() || password==null || password.isEmpty()){
            //4.通过request对象传递数据
            req.setAttribute("message","用户名或者密码错误");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/register.jsp");
            dispatcher.forward(req,resp);
        }else {
            //重定向的方式实现页面的跳转
            UserDao userDao = new UserDao();
            User user = userDao.findUserByUsername(username);
            if(user != null&& user.getUsername() != null){
                req.setAttribute("message","用户名存在");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/register.jsp");
                dispatcher.forward(req,resp);
            }else {
                user.setUsername(username);
                user.setPassword(password);
                user.setName(name);
                user.setName(name);
                user.setPhone(phone);
                user.setAddress(address);
                user.setEmail(email);
                int rows = userDao.addUser(user);
                if(rows > 0){
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
                    dispatcher.forward(req,resp);
                }else {
                    req.setAttribute("massage","执行插入操作失败");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/register.jsp");
                    dispatcher.forward(req,resp);
                }
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
