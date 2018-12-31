<html>
<head>
    <meta charset="utf-8">
    <title>Библиотека</title>
    <#--<%@ include file="styleAndJs.ftl" %>-->
    <#include "styleAndJs.ftl"/>
</head>
<body>
<#--<t:navbar/>-->
<#include "../macros/navbar.ftl"/>
<div class="container library-container">
    <h2>Наша библиотека</h2>
    <div class="row books-row">
        <#list books as book>
            <div class="col-sm-12 col-lg-3 book-item">
                <a href="book?name=${book.id}"><img src="${book.path}"></a>
            </div>
        </#list>
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
