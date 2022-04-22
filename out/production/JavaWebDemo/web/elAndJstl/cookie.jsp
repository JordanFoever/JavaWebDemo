<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie对象</title>
</head>
<body>
   <h2>使用EL表达式读取cookie的信息</h2>
	Cookie对象的信息：
	${cookie.cart} <br /> 
	Cookie对象的名称和值：<br /> 
	名称：${cookie.cart.name}
	，值：${cookie.cart.value}
	
</body>
</html>

