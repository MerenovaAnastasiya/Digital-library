<%--
  Created by IntelliJ IDEA.
  User: merenaas
  Date: 03.11.18
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="/style/style.css">
</head>

<body class="align">


<div class="grid">
    <form method="post" class="form login">
        <header class="login__header">
        </header>

        <div class="login__body">
            <t:input-login/>
            <div class="error-message">
                <c:if test="${chekLogin == false}">
                    Неверный формат логина
                </c:if>
                <c:if test="${checkLoginForAvailability == false}">
                    Пользователь с таким логином уже существует
                </c:if>
            </div>
            <t:input-email/>
            <div class="error-message">
                <c:if test="${chekEmail == false}">
                    Неверный формат Email
                </c:if>
                <c:if test="${checkEmailForAvailability == false}">
                    Пользователь с таким Email уже существует
                </c:if>
            </div>
            <t:input-password/>
            <div class="error-message">
                <c:if test="${chekPassword == false}">
                    Неверный формат пароля
                </c:if>
            </div>
            <div class="form__field">
                <span>Запомнить меня </span><input type="checkbox" name="checkbox">
            </div>
        </div>
        <footer class="login__footer">
            <input type="submit" value="Регистрация">
        </footer>
    </form>
</div>
</body>
</html>
