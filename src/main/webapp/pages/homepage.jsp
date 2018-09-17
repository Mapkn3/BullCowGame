<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <title>Home page</title>
</head>
<body class="horiz-center vert-center">
<div class="content no-padding">
    <fieldset class="no-margin">
        <h1 class="center-text">Игра "Быки и коровы"</h1>
        <p class="center-text">
            Компьютер загадывает 4-х значное число. Цифры загаданного числа не повторяются.<br/>
            Ваша задача угадать загаданное число. У вас неограниченное число попыток.<br/>
            После каждой попытки компьютер сообщает сколько цифр точно угадано (бык) и сколько цифр угадано без учета
            позиции (корова).<br/>
            По ответу компьютера вы должны за несколько ходов угадать число.<br/>
        </p>
        <p class="left-text">
            Пример:<br/>
            7328 -- загаданное число<br/>
            0819 -- 0Б1К<br/>
            4073 -- 0Б2К<br/>
            5820 -- 0Б1К<br/>
            3429 -- 1Б1К<br/>
            5960 -- 0Б0К<br/>
            7238 -- 2Б2К<br/>
            7328 -- 4Б0К (число угадано)<br/>
        </p>
    </fieldset>
    <div class="center-text">
        <b><a href="<c:url value="/game"/>">Начать игру</a></b><br/>
        <a href="<c:url value="/highScore"/>">Таблица рекордов</a>
    </div>
</div>
</body>
</html>
