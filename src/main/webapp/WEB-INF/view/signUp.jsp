<%--
  Created by IntelliJ IDEA.
  User: merenaas
  Date: 03.11.18
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="/static/style/style.css">
</head>
<body class="align">


<div class="grid">
    <%--<form method="post" class="form login">--%>
    <form:form method="post" cssClass="form login" modelAttribute="user">
        <header class="login__header">
        </header>
        <div class="login__body">
            <div class="form__field">
                <form:input path="login"></form:input>
            </div>
            <div class="form__field">
                <form:input path="email"/>
            </div>
            <div class="form__field">
                <form:password path="password"/>
            </div>
            <div class="form__field">
                <span>Запомнить меня </span>
                <form:checkbox path="checkbox"/>
            </div>
        </div>
        <footer class="login__footer">
            <input type="submit" value="Регистрация">
            <p><a href="/signIn">Вход</a></p>
        </footer>
    </form>
    </form:form>
</div>
</body>
</html>
