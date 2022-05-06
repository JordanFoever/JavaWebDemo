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
 * @date 2022/5/6 -15:19
 * @Description
 */

@WebServlet(name = "AddGoodsToCartServlet",urlPatterns = "/addGoodsToCartServlet")
public class AddGoodsToCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("id"));
        GoodsDao goodsDao = new GoodsDao();
        Goods goods = goodsDao.findGoodsById(id);

        HttpSession session = req.getSession();
        // 从session中取购物车信息
        ShoppingCart cart =  (ShoppingCart) session.getAttribute("cart");
        // 购物车的信息为空
        if(cart == null){
            cart = new ShoppingCart();
        }
        //将产品添加到购物车里面去
        cart.AddProduct(goods);
        //将购物车的信息存入到session中去
        session.setAttribute("cart",cart);

        //跳转产品展现页面(请求转发和重定向 可以调用页面也可以调用servlet)
        resp.sendRedirect(req.getContextPath()+"/goodsListServlet");

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


}
