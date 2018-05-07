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
<form name="MyForm1" action="/updateuser/${user.id}" method="post">
    <p><input class="input" name="name" value="${user.name}" type="text"/> Ваше имя </p>
    <p><input class="input" name="email" value="${user.email}" type="text"/> Электронная почта </p>
    <p><input class="input" name="password" value="${user.password}" type="text"/> Пароль</p>
    <p><input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"></p>
    <p>
        <select name="role" id="">
            <option ${user.role == 'ROLE_ADMIN' ? 'selected' : ''} value="ROLE_ADMIN">admin</option>
            <option ${user.role == 'ROLE_USER' ? 'selected' : ''} value="ROLE_USER">user</option>
        </select>
        Установите роль
    </p>
    <p><input id="submit" value="Обновить" type="submit"/></p>
</form>
</body>
</html>
