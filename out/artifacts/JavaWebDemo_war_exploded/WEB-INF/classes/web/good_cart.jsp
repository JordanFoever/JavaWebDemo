<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: win
  Date: 2022/5/6
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车界面</title>
</head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/cart.css">
<body>
<div class="header">
    <a href="index.jsp">首页</a>
    <a href="#">商品分类</a>
    <a href="cake_list.jsp">热销</a>
    <a href="#">新品</a>
    <!--登录成功后，显示个人中心和退出标签-->
    <a href="#">个人中心</a>
    <a href="#">退出</a>
    <!--没有登录，显示登录和注册标签-->
    <a href="login.jsp">登录</a>
    <a href="regist.jsp">注册</a>
    <a href="cart.jsp">购物车</a>
    <!--登录的是超级用户，显示后台管理标签-->
    <a href="admin/admin_index.jsp">后台管理</a>
</div>
<div class="title">
    <h2>我的购物车</h2>
</div>
<div class="container">

    <c:forEach items="${sessionScope.cart.items}" var="item">
        <div class="cart-heard">
            <div class="cart-img"><img src="${pageContext.request.contextPath}${item.goods.image1}" alt=""></div>
            <div class="cart-item">
                <h2>${item.goods.name}</h2>
                <h3><span>单价:￥${item.goods.price}</span></h3>
                <h3><span>数量:${item.number}</span></h3>
                <a href="${pageContext.request.contextPath}/updateCartNumberServlet?id=${item.goods.id}&number=1" class="info">增加</a>
                <a href="${pageContext.request.contextPath}/updateCartNumberServlet?id=${item.goods.id}&number=-1" class="sub">减少</a>
                <a href="${pageContext.request.contextPath}/removeGoodsFormCartServlet?id=${item.goods.id}" class="delete">删除</a>
            </div>
        </div>
    </c:forEach>

    <div class="cart-price">
        <h3>订单金瓯:${sessionScope.cart.sumMoney}</h3>
        <a href="#" class="submit">提交订单</a>
    </div>
</div>

</body>
</html>
