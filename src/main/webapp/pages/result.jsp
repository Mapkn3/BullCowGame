<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <title>Congratulation</title>
</head>
<body class="horiz-center">
<div class="content">
    <a href="<c:url value="/home"/>">Вернуться на главную страницу</a>
    <fieldset>
        <h1>Поздравляем, <c:out value="${sessionScope.user.nickname}"/>!</h1>
        <h2>Вы отгадали загаданное число:</h2>
        <h3><b><u><c:out value="${sessionScope.secretNumber}"/></u></b></h3>
        <h2>Количество попыток:</h2>
        <h3><b><u><c:out value="${sessionScope.attempts}"/></u></b></h3>
        <h2>Вспомним, как это было...</h2>
        <table cellspacing="0">
            <c:forEach var="attempt" items="${sessionScope.score}">
                <tr>
                    <th>${attempt.number}</th>
                    <td>=></td>
                    <td>${attempt.result}</td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</div>
</body>
</html>
