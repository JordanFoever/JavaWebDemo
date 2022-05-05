package com.hxut.Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author weijiangquan
 * @date 2022/5/5 -14:07
 * @Description
 */
@WebServlet("/queryCookieServlet")
public class QueryCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie:cookies){
            //获取cookie的名称
            String name = cookie.getName();
            //获取cookie的值
            String value = cookie.getValue();
            System.out.println("cookie的名称"+name+":cookie的值"+value);
            // 解码
            String newName = URLDecoder.decode(name, "utf-8");
            String newValue = URLDecoder.decode(value, "utf-8");
            System.out.println("cookie的名称解码后"+newName+";cookie的值解码后"+newValue);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }


}
