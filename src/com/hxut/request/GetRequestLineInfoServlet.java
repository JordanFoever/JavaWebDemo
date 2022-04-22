package com.hxut.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能：获取请求行信息的相关方法
 */
@WebServlet("/GetRequestLineInfoServlet")
public class GetRequestLineInfoServlet extends HttpServlet {

    /**
     * Default constructor. 
     */
    public GetRequestLineInfoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		// 获得请求行的相关信息
		pw.println(request.getMethod()); // 获取请求的方法
		pw.println(request.getRequestURI()); // 获取URI
		pw.println(request.getQueryString()); // 获取请求行中的参数
		pw.println(request.getProtocol()); // 获取请求行中的协议名和版本
		pw.println(request.getContextPath()); // 获取虚拟目录
		pw.println(request.getPathInfo());
		pw.println(request.getPathTranslated());
		pw.println(request.getRemoteAddr()); // 客户端ip
		pw.println(request.getRemoteHost()); // 客户端主机名
		pw.println(request.getRemotePort()); // 客户端端口
		pw.println(request.getLocalAddr()); // 服务器接收ip
		pw.println(request.getLocalName()); // 服务器接收主机名
		pw.println(request.getLocalPort()); // 服务器接收端口
		pw.println(request.getServerName()); // 请求指向的主机名
		pw.println(request.getServerPort()); // 请求指向的端口
		pw.println(request.getScheme()); // 获得协议名
		pw.println(request.getRequestURL()); // 完整的URL

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
