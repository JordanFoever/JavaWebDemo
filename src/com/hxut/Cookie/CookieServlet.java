package com.hxut.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author weijiangquan
 * @date 2022/5/5 -14:06
 * @Description
 */
@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //创建cookie
        Cookie cookie1 = new Cookie("city", "wuhan");

        //将cookie1的有效时长设置为30秒
        cookie1.setMaxAge(30); //创建到销毁就是30s

        Cookie cookie2 = new Cookie("address", "hxut");


        // cookie的name或者value 存在中文或者特殊符号   创建的时候,需要编码
        Cookie cookie3 = new Cookie(URLEncoder.encode("地址","utf-8"),URLEncoder.encode("华夏学院","utf-8"));

        //发送cookie
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
