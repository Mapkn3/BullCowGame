<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <title>High Score</title>
</head>
<body class="horiz-center">
<div class="content">
    <a href="<c:url value="/home"/>">Вернуться на главную страницу</a>
    <h1>Таблица рекордов</h1>
    <fieldset>
        <table cellspacing="0" border="1">
            <tr>
                <th>Имя пользователя</th>
                <td>Среднее число попыток</td>
            </tr>
            <c:forEach var="score" items="${requestScope.highScore}">
                <tr>
                    <th class="left-text">${score.account.nickname}</th>
                    <td class="right-text">${score.mean}</td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</div>
</body>
</html>
