<html>
<head>
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
            <a href="/main">Lhander</a>
        </div>

        <nav id="main-nav-wrap">
            <ul class="main-navigation">
                <li><a href="/library">Библиотека</a></li>
                <li class="highlight with-sep">
                    <#if authorized??>
                        <#if authorized == false><a href="/signIn" title="">Войти</a></#if>
                        <#if authorized == true><a href="profile" style="color: white">${user.login}</a></#if>
                    <#else><a href="/signIn" title="">Войти</a>
                    </#if>
                </li>
            </ul>
        </nav>

        <a class="menu-toggle" href="#"><span>Menu</span></a>

    </div>

</header>
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
