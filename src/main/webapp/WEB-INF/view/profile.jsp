<%--
  Created by IntelliJ IDEA.
  User: merenaas
  Date: 05.11.18
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <%@ include file="styleAndJs.jsp" %>
    <title>Личная страница</title>
</head>

<body>
<header class="sticky">
    <div class="row">
        <div class="logo">
            <a href="/main">DLibrary</a>
        </div>
        <nav id="main-nav-wrap">
            <ul class="main-navigation">
                <li><a href="/library">Библиотека</a></li>
                <li class="highlight with-sep">
                    <c:if test="${(authorized == false) || (authorized == null)}"><a href="/signIn">Войти</a></c:if>
                    <c:if test="${authorized == true}">
                        <form action="logOut">
                            <input type="submit" value="выйти">
                        </form>
                    </c:if></li>
            </ul>
        </nav>
    </div>
</header>

<div class="container profile-container">
    <h2>Оформление заказа</h2>
    <div class="row">
        <div class="col-sm-10">
            <c:if test="${fn:length(basket.books) == 0}">
                <p>В корзину ничего не добавлено<br>
                    <a href="/library">Перейти в каталог</a>
                </p>
            </c:if>
        </div>
    </div>
    <c:if test="${fn:length(basket.books) > 0}">
    <%@include file="ordering.jsp"%>
        <h2>книги</h2>
    </c:if>
    <div class="row profile-basket">
        <c:forEach items="${userBooks}" var="book">
            <div class="col-sm-2">
                <div class="inner profile-book-item">
                    <img src="${book.key.path}">
                </div>
            </div>
            <div class="book-description col-sm-2">
                <p>
                        ${book.key.bookName}
                </p>
                <p>
                    Количество: ${book.value}
                </p>
                <%--<form action="/increaseAmount">--%>
                    <%--<input type="submit" value="+">--%>
                <%--</form>--%>
                <%--<form action="/reduceAmount">--%>
                    <%--<input type="submit" value="-">--%>
                <%--</form>--%>
            </div>
        </c:forEach>
    </div>
</div>
<t:fixed-footer/>
<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/js/plugins.js"></script>
<script src="/js/main.js"></script>
</body>
</html>
