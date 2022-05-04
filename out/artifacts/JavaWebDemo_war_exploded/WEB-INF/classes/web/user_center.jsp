<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/1/001
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>



<div class="form-block">
    <h3>个人中心</h3>
    <form action="updateUserServlet" method="post">
        <div class="item">
            <input class="txt" type="hidden" name="id" value="${sessionScope.user.id}">
            <input class="txt" type="hidden" name="username" value="${sessionScope.user.username}">
            <span class="lab">收货人：</span><input class="txt" type="text"  name="name" value="${sessionScope.user.name}" >
        </div>
        <div class="item">
            <span class="lab">收货电话：</span><input class="txt" type="text" name="phone" value="${sessionScope.user.phone}" >
        </div>
        <div class="item">
            <span class="lab">收货地址：</span><input class="txt" type="text" name="address" value="${sessionScope.user.address}">
        </div>
        <div class="btn-block">
            <input class="btn" type="submit" value="提交">
        </div>
    </form>
    ${requestScope.message}

    <form action="" method="post">
        <h4>安全信息</h4>
        <div class="item">
            <span class="lab">原密码：</span><input class="txt" type="password" name="password"  >
        </div>
        <div class="item">
            <span class="lab">新密码：</span><input class="txt" type="password" name="newpassword" >
        </div>

        <div class="btn-block">
            <input class="btn" type="submit" value="提交">
        </div>

    </form>

</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
