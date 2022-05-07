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
 * @date 2022/5/6 -17:07
 * @Description
 */

@WebServlet("/removeGoodsFormCartServlet")
public class RemoveGoodsFormCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        GoodsDao goodsDao = new GoodsDao();
        //通过id查询产品的信息
        Goods goods = new Goods();
        goods = goodsDao.findGoodsById(id);
        //通过request对象获取session
        HttpSession session = req.getSession();
        //从session对象中获取购物车信息
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        //将产品信息从购物车中删除
        cart.removeProduct(goods);
        session.setAttribute("cart",cart);
        //重定向到显示购物车页面
        resp.sendRedirect(req.getContextPath()+"/good_cart.jsp");



    }
}


