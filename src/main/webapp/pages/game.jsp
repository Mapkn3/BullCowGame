<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css">
    <title>Bull-Cow Game</title>
</head>
<body class="horiz-center">
<div class="content">
    <h1 class="center-text">Быки и коровы</h1>
    <p class="center-text">Б-угадана цифра и место<br/>К-угадано только цифра</p>
    <a href="<c:url value="/home"/>">Вернуться на главную страницу</a>
    <form action="<c:url value="/game"/>" method="post">
        <fieldset class="no-margin">
            <label for="number">Введите число без повторяющихся цифр:</label><br/>
            <input type="text" id="number" name="number" oninput="modifyNumber()" autofocus/>
            <button type="submit" id="checkButton" disabled>проверить</button>
        </fieldset>
        <div class="horiz-center">
            <table cellspacing="0" class="center-text">
                <tr>
                    <td>
                        <button type="button" onclick="add('1')">1</button>
                    </td>
                    <td>
                        <button type="button" onclick="add('2')">2</button>
                    </td>
                    <td>
                        <button type="button" onclick="add('3')">3</button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="button" onclick="add('4')">4</button>
                    </td>
                    <td>
                        <button type="button" onclick="add('5')">5</button>
                    </td>
                    <td>
                        <button type="button" onclick="add('6')">6</button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="button" onclick="add('7')">7</button>
                    </td>
                    <td>
                        <button type="button" onclick="add('8')">8</button>
                    </td>
                    <td>
                        <button type="button" onclick="add('9')">9</button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="button" onclick="remove(4)">c</button>
                    </td>
                    <td>
                        <button type="button" onclick="add('0')">0</button>
                    </td>
                    <td>
                        <button type="button" onclick="remove(1)"><</button>
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <div class="horiz-center">
        <fieldset>
            <table>
                <tr>
                    <td>Ваша попытка</td>
                    <td>=></td>
                    <td>Результат</td>
                </tr>
                <c:forEach var="attempt" items="${sessionScope.score}">
                    <tr>
                        <th class="center-text">${attempt.number}</th>
                        <td>=></td>
                        <td class="center-text">${attempt.result}</td>
                    </tr>
                </c:forEach>
            </table>
        </fieldset>
    </div>
</div>
<script>
    var secretNumber = document.getElementById("number");
    var secretNumberLength = secretNumber.value.length;
    var checkButton = document.getElementById("checkButton");
    var modifyNumber = function () {
        secretNumber.value = secretNumber.value.split('')
            .filter(
                function (item, pos, self) {
                    return item in '0123456789'.split('') && self.indexOf(item) === pos;
                }
            )
            .slice(0, 4)
            .join('');
        if (secretNumber.value.length === 4) {
            checkButton.removeAttribute('disabled');
        } else {
            checkButton.setAttribute('disabled', '');
        }
    };
    var add = function (digit) {
        secretNumber.value += digit;
        modifyNumber();
    };
    var remove = function (count) {
        secretNumber.value = secretNumber.value.split('').slice(0, secretNumberLength - count).join('');
        modifyNumber();
    };
</script>
</body>
</html>
