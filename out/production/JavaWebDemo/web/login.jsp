<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/24/024
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="form-block">

    <form action="loginServlet" method="post">
        <div class="item">
            <span class="lab">用户名：</span><input class="txt" type="text" id="userid" name="username" placeholder="用户名" value="${cookie.username.value}">
        </div>
        <div class="item">
            <span class="lab">密码：</span><input class="txt" type="password" name="password" placeholder="密码" value="${cookie.password.value}">
        </div>

          <div class="item">
            <span class="lab"></span>
            <div class="item-option">
                <input type="checkbox" name="remebers" value="true">&nbsp;记住密码：
            </div>
        </div>

        <div class="btn-block">
            <input class="btn" type="submit" value="登录">
            <input class="btn" type="reset" value="重置">
        </div>

    </form>
    ${requestScope.message}

</div>

<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>
