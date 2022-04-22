<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/4/004
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp内置对象</title>
</head>
<body>
<%
String name1=(String )request.getAttribute("name1");
String name2=(String )session.getAttribute("name2");
String name3=(String )application.getAttribute("name3");


//通过PageContext对象传递值
    pageContext.setAttribute("name4","Java开发工程师");
    String name4=(String )pageContext.getAttribute("name4");

%>
request对象中的值:<%=name1%><br>
session对象中的值:<%=name2%><br>
application对象中的值:<%=name3%><br>
pageContext对象中的值:<%=name4%><br>
</body>

</html>
