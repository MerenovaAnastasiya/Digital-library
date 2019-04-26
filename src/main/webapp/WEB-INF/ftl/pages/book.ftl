<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
      integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link rel="stylesheet" href="/static/style/base.css">
<link rel="stylesheet" href="/static/style/fonts.css">
<link rel="stylesheet" href="/static/style/main.css">
<link rel="stylesheet" href="/static/style/style.css">
<script src="/static/js/modernizr.js"></script>
</head>
<body>
<#--<t:navbar/>-->
<header>
    <div class="row">
        <div class="logo">
            <a href="/main">Главная</a>
        </div>
        <nav id="main-nav-wrap">
            <ul class="main-navigation">
                <li><a href="/library">Библиотека</a></li>
                <li class="highlight with-sep">
                        <#if user??>
                            <a href="/profile" style="color: white">${user.login}</a>
                        <#else><a href="/signIn" title="">Войти</a></a></#if>
                </li>
            </ul>
        </nav>

        <a class="menu-toggle" href="#"><span>Menu</span></a>

    </div>

</header>
<div class="container book-page">
    <div class="row">
        <div class="col-sm-4">
            <img src="${book.path}" class="book-item-img">
        </div>
        <div class="col-sm-8" style="padding-top: 30px;">
            <h1>${book.bookName}</h1>
            <p>
            ${book.description}
            </p>
            <#if user??>
            <#--<form method="get" action="/addBook?isbn13=123">-->
                <#--&lt;#&ndash;<input type="text" value="${book.id}" name="book-id" style="display: none">&ndash;&gt;-->
            <a href="/addBook?isbn13=${book.ISBN13}">
                <input type="submit" value="Заказать" class="button"">
            </a>
            <#--</form>-->


            </#if>
        </div>
    </div>
</div>
<footer class="page-footer font-small unique-color-dark fixed-bottom">
    <div class="footer-copyright text-center py-3">© 2018 Copyright: Merenaas
    </div>
</footer>
<#--<t:fixed-footer/>-->
<#--<#include "../macros/fixed-footer.ftl"/>-->
<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/js/plugins.js"></script>
<script src="/js/main.js"></script>
</body>
</html>
