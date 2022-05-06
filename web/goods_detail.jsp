<%--
  Created by IntelliJ IDEA.
  User: win
  Date: 2022/5/6
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/single-good.css" />
</head>
</head>
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
    <a href="admin/admin_index.jsp">后台管理</a>|

</div>
<div class="container">
    <div class="sigle-grids">
        <div class="sigle-grid">
            <div id="carousel" class="carousel slide" data-ride="carousel">
                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="picture/1-1.jpg">
                    </div>
                    <div class="item">
                        <img src="picture/1-2.jpg">
                    </div>
                    <div class="item">
                        <img src="picture/1-3.jpg">
                    </div>
                </div>
            </div>
            <div class="img-contral">
                <ol class="img-contral-list">
                    <li data-target="#carousel" data-slide-to="0" class="active"><img src="picture/1-1.jpg">
                    </li>
                    <li data-target="#carousel" data-slide-to="1"><img src="picture/1-2.jpg"></li>
                    <li data-target="#carousel" data-slide-to="2"><img src="picture/1-3.jpg"></li>
                </ol>
            </div>
        </div>
        <div class="sigle-grid">
            <h3>草莓冰淇淋</h3>
            <div class="tag">
                <p>分类 : <a href="#">冰淇淋系列</a></p>
            </div>
            <p>甜郁草莓配合冰淇淋的丝滑口感,让清爽与浪漫在爱情果园激情碰撞,恋上草莓,这份心情,美妙非凡.
                主口味:草莓口味 主要原料:草莓果溶 草莓 甜度:三星（满五星） 最佳食用温度：-12至-15摄氏度</p>
            <div class="galry">
                <div class="prices">
                    <h5 class="item_price">¥ 299.0</h5>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="btn_form">
                <a href="#">加入购物车</a>
            </div>
        </div>
        <div class="single-grid1">
            <ul style="list-style:none;">
                <li><a href="#">全部系列</a></li>
                <li><a href="#">冰淇淋系列</a></li>
                <li><a href="#">零食系列</a></li>
                <li><a href="#">儿童系列</a></li>
                <li><a href="#">法式系列</a></li>
                <li><a href="#">经典系列</a></li>
                <li><a href="#">节日系列</a></li>
                <li><a href="#">买不起系列</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="copy">
    版权信息
</div>
</body>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</html>
