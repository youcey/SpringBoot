<%--
  Created by IntelliJ IDEA.
  User: BD-PC28
  Date: 2018/2/26
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form method="get" action="/user/login">
        用户名：<input type="text" name="name"/><br/>
        密码：<input type="text" name="pwd"/>
        <input type="submit" value="登陆"/>
    </form>
</body>
</html>
