<!DOCTYPE html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/style/base.css">
    <link rel="stylesheet" href="/static/style/fonts.css">
    <link rel="stylesheet" href="/static/style/main.css">
    <link rel="stylesheet" href="/static/style/style.css">
    <script src="/static/js/modernizr.js"></script>
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
                <#--<li class="highlight with-sep">-->
                    <#--<#if authorized??>-->
                        <#--<#if authorized == false><a href="/signIn" title="">Войти</a></#if>-->
                        <#--<#if authorized == true>-->
                            <#--<form action="logOut">-->
                                <#--<input type="submit" value="выйти">-->
                            <#--</form>-->
                        <#--</#if>-->
                    <#--<#else>-->
                        <#--<form action="logOut">-->
                            <#--<input type="submit" value="выйти">-->
                        <#--</form>-->
                    <#--</#if>-->
                <#--</li>-->
            </ul>
        </nav>
    </div>
</header>

<div class="container profile-container">
    <h2>Оформление заказа</h2>
    <div class="row">
        <div class="col-sm-10">
        </div>
    </div>
    <#--<#include "ordering.ftl"/>-->
        <h2>книги</h2>
    <div class="row profile-basket">
        <#if userBooks??>
        <#list userBooks as book, value>
            <div class="col-sm-2">
                <div class="inner profile-book-item">
                    <img src="${book.path}">
                </div>
            </div>
            <div class="book-description col-sm-2">
                <p>
                        ${book.bookName}
                </p>
                <p>
                    Количество: ${value}
                </p>
            </div>
        </#list>
        </#if>
    </div>
</div>
<footer class="page-footer font-small unique-color-dark fixed-bottom">
    <div class="footer-copyright text-center py-3">© 2018 Copyright: Merenaas
    </div>
</footer>

<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/js/plugins.js"></script>
<script src="/js/main.js"></script>
</body>
</html>
