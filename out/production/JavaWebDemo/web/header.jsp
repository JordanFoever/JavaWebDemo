<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/1/001
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
    <a href="index.jsp">首页</a>
    <a href="#">商品分类</a>
    <a href="goodsListServlet">热销</a>
    <a href="#">新品</a>


    <!--登录成功后，显示个人中心和退出标签-->
    <c:if test="${!empty sessionScope.user}">
        <a href="user_center.jsp">个人中心</a>
        <a href="#">退出</a>

    </c:if>
    <c:if test="${empty sessionScope.user}">
        <!--没有登录，显示登录和注册标签-->
        <a href="login.jsp">登录</a>
        <a href="register.jsp">注册</a>

    </c:if>









    <a href="cart.jsp">购物车</a>

    <!--登录的是超级用户，显示后台管理标签-->
    <a href="admin/admin_index.jsp">后台管理</a>|

</div>
