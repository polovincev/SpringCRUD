<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 03.12.2017
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p style="color: red; height: 15px;">${error}</p>


<style>
    td {
        width: auto;
        min-width: 60px;
    }
</style>
<%--<c:if test="${!empty itemList}">--%>
<table class="item-table">
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Email</th>
        <th>Password</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>

    <c:forEach items="${userLists}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.email}</td>
            <td>${item.password}</td>
            <td><a href="/admin/update/${item.id}">Обновить</a></td>
            <td><a href="/admin/delete/${item.id}">Удалить</a></td>
        </tr>
    </c:forEach>

</table>
<%--</c:if>--%>
<hr/>
<form name="MyForm" action="/admin/add" method="post">
    <p><input class="input" name="name" type="text"/> Ваше имя</p>
    <p><input class="input" name="email" type="text"/> Электронная почта</p>
    <p><input class="input" name="password" type="text"/> Пароль</p>
    <p><input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"></p>
    <p>
        <select name="role" id="">
            <option value="ROLE_ADMIN">admin</option>
            <option value="ROLE_USER">user</option>
        </select>
        Установите роль
    </p>
    <p><input id="submit" value="Отправить" type="submit"/></p>
</form>

<hr/>
<a href="/user">Перейти на страницу пользователя</a>
<br>
<a href="/admin">Перейти на страницу админа</a>
<br>
<a href="/login">Перейти на страницу логина</a>
</body>
</html>

