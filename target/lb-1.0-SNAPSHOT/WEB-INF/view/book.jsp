<%--
  Created by IntelliJ IDEA.
  User: merenaas
  Date: 07.11.18
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>

<%@ include file="styleAndJs.jsp" %>
<body>
<t:navbar/>
<div class="container book-page">
    <div class="row">
        <div class="col-sm-4">
            <img src="${book.path}" class="book-item-img">
        </div>
        <div class="col-sm-8" style="padding-top: 30px;">
            <h1>${book.bookName}</h1>
            <h2>${book.author}</h2>
            <p>
                ${book.description}
            </p>
            <c:if test="${authorized == true}">
            <form method="get" action="/addBook">
                <input type="text" value="${book.id}" name="book-id" style="display: none">
                <input type="submit" value="Заказать" class="button">
            </form>
            </c:if>
        </div>
    </div>
</div>
<t:fixed-footer/>
<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/js/plugins.js"></script>
<script src="/js/main.js"></script>
</body>
</html>
