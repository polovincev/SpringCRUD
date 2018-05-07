<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 05.12.2017
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="MyForm1" action="/login" method="post">
    <p><input class="input" name="username" value="${name}" type="text"/> Ваше имя </p>
    <p><input class="input" name="password" value="${password}" type="text"/> Пароль</p>
    <p><input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"></p>
    <p><input id="submit" value="Логин" type="submit"/></p>
</form>
<p style="color: red; height: 15px;">${error}</p>
</body>
</html>