package com.hxut.servlet;

import com.hxut.dao.UserDao;
import com.hxut.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author weijiangquan
 * @date 2022/5/4 -19:27
 * @Description
 */
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String username = req.getParameter("username");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        user.setPhone(phone);

        UserDao userDao = new UserDao();
        int rows = userDao.updateUser(user);

        if(rows>0){
            HttpSession session = req.getSession();
            session.setAttribute("user",userDao.findUserByUsername(username));
            req.setAttribute("message","收件信息更新成功");

            RequestDispatcher dispatcher = req.getRequestDispatcher("/user_center.jsp");
            dispatcher.forward(req,resp);
        }else {
            req.setAttribute("message","收件信息更新失败");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/user_center.jsp");
            dispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
