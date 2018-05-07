<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 14.12.2017
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${pageContext.request.userPrincipal.name}, у вас нет прав для посещения данной страницы</p>
<hr/>
<a href="/user">Перейти на страницу пользователя</a>
<br>
<a href="/admin">Перейти на страницу админа</a>
<br>
<a href="/login">Перейти на страницу логина</a>
</body>
</html>
