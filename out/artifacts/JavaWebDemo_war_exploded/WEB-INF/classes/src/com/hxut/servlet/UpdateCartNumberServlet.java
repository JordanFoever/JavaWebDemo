package com.hxut.servlet;

import com.hxut.dao.GoodsDao;
import com.hxut.dao.ShoppingCart;
import com.hxut.model.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author weijiangquan
 * @date 2022/5/6 -16:52
 * @Description
 */
@WebServlet("/updateCartNumberServlet")
public class UpdateCartNumberServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取页面中传入的number的值,返回的是字符串,需要转换成int类型
        int number = Integer.parseInt(req.getParameter("number"));
        int id = Integer.parseInt(req.getParameter("id"));

        //通过id查询产品的信息
        Goods goods = new Goods();
        GoodsDao goodsDao = new GoodsDao();
        goods = goodsDao.findGoodsById(id);
        //通过request对象获取session
        HttpSession session = req.getSession();
        // 从session中获取购物信息
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        //将产品数据的信息更新
        cart.updateProductNumber(goods,number);
        session.setAttribute("cart",cart);
        //重定向的方式显示购物车的信息页面

        resp.sendRedirect(req.getContextPath()+"/good_cart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
