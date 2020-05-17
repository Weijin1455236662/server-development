<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>景区网站管理员登录</title>
</head>
<body>

<form action="loginCheck" method="post">
    用户名：
    <input type="text" name="userName">

    <p>${errorMessage.userNameError}</p>

    密 码：
    <input type="password" name="password">

    <p>${errorMessage.passwordError}</p>

    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</form>

</body>
</html>
