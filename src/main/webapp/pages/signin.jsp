<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <title>Sign In</title>
</head>
<body class="horiz-center vert-center">
<div class="content center-text">
    <h1>Игра "Быки и коровы"</h1>
    <form action="<c:url value="/signin"/>" class="signin" method="post">
        <fieldset>
            <legend><fieldset><b>Вход</b></fieldset></legend>
            <table cellspacing="0">
                <tr>
                    <th class="right-text"><label for="login">Имя пользователя</label></th>
                    <td><input id="login" name="nickname" type="text"/></td>
                </tr>
                <tr>
                    <th class="right-text"><label for="password">Пароль</label></th>
                    <td><input id="password" name="password" type="password"/></td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <button type="submit">Войти</button>
                    </td>
                </tr>
            </table>
            <div class="error"><c:out value="${param.getOrDefault('error', '')}"/></div>
        </fieldset>
    </form>
    <a href="<c:url value="/signup"/>" class="center-text">Регистрация</a>
</div>
</body>
</html>
