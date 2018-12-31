<html>
<head>
        <#include "styleAndJs.ftl"/>
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
                    <#if authorized??>
                        <#if authorized == false><a href="/signIn" title="">Войти</a></#if>
                        <#if authorized == true>
                            <form action="logOut">
                                <input type="submit" value="выйти">
                            </form>
                        </#if>
                    <#else>
                        <form action="logOut">
                            <input type="submit" value="выйти">
                        </form>
                    </#if>
                </li>
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
    <#include "ordering.ftl"/>
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
<#include "../macros/fixed-footer.ftl"/>
<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/js/plugins.js"></script>
<script src="/js/main.js"></script>
</body>
</html>
