<%--
  Created by IntelliJ IDEA.
  User: merenaas
  Date: 22.11.18
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Библиотека</title>
    <%@ include file="styleAndJs.jsp" %>
</head>
<body>
<t:navbar/>
<div class="container library-container">
    <h2>Наша библиотека</h2>
    <div class="row books-row">
        <c:forEach items="${books}" var="book">
            <div class="col-sm-12 col-lg-3 book-item">
                <a href="book?name=${book.id}"><img src="${book.path}"></a>
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
