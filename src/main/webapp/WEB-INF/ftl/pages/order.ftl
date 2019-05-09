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
                <li class="highlight with-sep">
                    <form action="/logOut">
                        <input type="submit" value="выйти">
                    </form>
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
    <#import "/spring.ftl" as spring />
    <div class="container">
        <form method="post" action="/checkOut">
            <@spring.bind "checkoutForm"/>
            <div class="row  mb-2">
                <div class="col-sm-2">
                    <label for="address">
                        Адрес доставки *
                    </label>
                </div>
                <div class="col-sm-5">
                <@spring.formInput "checkoutForm.address"/>
                </div>
            </div>
            <div class="row mb-2">
                <div class="col-sm-2">
                    <label for="email">
                        Электронная почта
                    </label>
                </div>
                <div class="col-sm-5">
                <@spring.formInput "checkoutForm.email"/>
                </div>
            </div>
            <div class="row mb-2">
                <div class="col-sm-2">
                    <label for="comment">
                        Комментарий
                    </label>
                </div>
                <div class="col-sm-5">
                <@spring.formInput "checkoutForm.comment"/>
                </div>
            </div>
            <div class="row mb-2">
                <div class="col-sm-2">
                    <label for="datedOfDelivery">
                        Дата доставки
                    </label>
                </div>
                <div class="col-sm-5">
                <@spring.formInput "checkoutForm.dateOfDelivery" "" "date"/>
                </div>
            </div>
            <div class="row mb-2">
                <div class="col-sm-2">
                    <label for="dateOfReturn">
                        Дата возврата
                    </label>
                </div>
                <div class="col-sm-5">
                <@spring.formInput "checkoutForm.dateOfReturn" "" "date"/>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">
                </div>
                <div class="col-sm-5" class="button large round ">
                    <input type="submit" value="Отправить" class="button">
                </div>
            </div>
        </form>
    </div>
    <h2>книги</h2>
    <div class="row profile-basket">
        <#if books??>
        <#list books as book>
            <div class="col-sm-2">
                <div class="inner profile-book-item">
                    <img src="${book.path}">
                </div>
            </div>
            <div class="book-description col-sm-2">
                <p>
                    ${book.bookName}
                </p>
            </div>
        </#list>
        </#if>
    </div>
    <#--<div class="row recent_orders"-->
         <#--<#if orders??>-->
             <#--<#list orders as order>-->
            <#--<p>${order.address}</p>-->
             <#--</#list>-->
         <#--</#if>-->
    <#--</div>-->
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
