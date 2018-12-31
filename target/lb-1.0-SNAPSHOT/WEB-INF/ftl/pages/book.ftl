<html>

<#include "styleAndJs.ftl"/>
<body>
<#--<t:navbar/>-->
<#include "../macros/navbar.ftl"/>
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
            <#if authorized??>
                <#if authorized == true>
            <form method="get" action="/addBook">
                <input type="text" value="${book.id}" name="book-id" style="display: none">
                <input type="submit" value="Заказать" class="button">
            </form>
                </#if>
            </#if>
        </div>
    </div>
</div>

<#--<t:fixed-footer/>-->
<#include "../macros/fixed-footer.ftl"/>
<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/js/plugins.js"></script>
<script src="/js/main.js"></script>
</body>
</html>
