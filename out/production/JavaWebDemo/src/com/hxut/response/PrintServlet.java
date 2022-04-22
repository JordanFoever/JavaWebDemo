package com.hxut.response;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(name="PrintServlet",urlPatterns = "/printServlet")
public class PrintServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, 
        HttpServletResponse response)throws ServletException, IOException {
		   //解决输出中文乱码问题
		   response.setContentType("text/html;charset=UTF-8");
		   String data="Java Web 应用开发";
		   //发送响应的相关方法  文本类型
		    PrintWriter out =response.getWriter();
			out.println(data);
		 //发送响应相关的方法    二进制
		 /*  OutputStream out =response.getOutputStream();
		   out.write(data.getBytes());*/



			
		}
		public void doPost(HttpServletRequest request, 
	        HttpServletResponse response)throws ServletException, IOException {
			doGet(request, response);
		}
	}
