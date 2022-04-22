package com.hxut.servlet;

import com.hxut.dao.GoodsDao;
import com.hxut.model.Goods;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GoodsListServlet",urlPatterns = "/goodsListServlet")
public class GoodsListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsDao goodsDao =new GoodsDao();

        ArrayList<Goods> goodsList=goodsDao.findAllGoods();
        req.setAttribute("goodsList",goodsList);
        //请求转发调转到good_list.jsp页面
        RequestDispatcher dispatcher = req.getRequestDispatcher("good_list.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
