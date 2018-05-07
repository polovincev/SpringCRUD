<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 13.12.2017
  Time: 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Привет, ${pageContext.request.userPrincipal.name}!</p>
<hr/>
<a href="/user">Перейти на страницу пользователя</a>
<br>
<a href="/admin">Перейти на страницу админа</a>
<br>
<a href="/login">Перейти на страницу логина</a>
</body>
</html>
