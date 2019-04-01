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
    <title>Вход</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="/style/style.css">
</head>

<body class="align">

<div class="grid">
    <form method="post" class="form login">
        <header class="login__header">
        </header>
        <div class="login__body">
            <div class="form__field">
                <input type="email" name="email" placeholder="<c:if test="${email == null}">Email</c:if>" value="${email}" required>
            </div>
            <div class="error-message">
            <c:if test="${checkSignIn == false}">Неверный email или пароль
            </c:if>
            </div>
            <div class="form__field">
                <input type="password" name="password" placeholder="Пароль" required style="margin-bottom: 20px">
            </div>
            <div class="form__field">
                <span>Запомнить меня </span><input type="checkbox" name="checkbox">
            </div>
        </div>

        <footer class="login__footer">
            <input type="submit" value="Войти">
            <p><a href="/signUp">Регистрация</a></p>
        </footer>
    </form>
</div>
</body>
</html>
