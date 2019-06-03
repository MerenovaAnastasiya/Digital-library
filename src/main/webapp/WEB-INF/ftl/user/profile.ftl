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
    <h2>Контактная информация</h2>
    <div class="row">
    <#import "/spring.ftl" as spring/>
        <form method="post" action="/updateProfile" class="update-inf-form">
            <@spring.bind "updateProfileForm"/>
            <table>
                <tr>
                    <td>
                        Логин
                    </td>
                    <td>
                        <#if user.login??>
                            <@spring.formInput "updateProfileForm.login" "placeholder='${user.login}'"/>
                        <#else>
                            <@spring.formInput "updateProfileForm.login" "placeholder='-Login-'"/>
                        </#if>
                    </td>
                    <td>
                        <div class="error-message">
                        <@spring.showErrors "updateProfileForm.login"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        Email
                    </td>
                    <td>
                        <#if user.email??>
                            <@spring.formInput "updateProfileForm.email" "placeholder='${user.email}'"/>
                        <#else>
                            <@spring.formInput "updateProfileForm.email" "placeholder='-Email-'"/>
                        </#if>
                    </td>
                    <td>
                        <div class="error-message">
                        <@spring.showErrors "updateProfileForm.email"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        Номер телефона
                    </td>
                    <td>
                    <#if user.phoneNumber??>
                            <@spring.formInput "updateProfileForm.phoneNumber" "placeholder='${user.phoneNumber}'"/>
                    <#else>
                        <@spring.formInput "updateProfileForm.phoneNumber" "placeholder='+7***-***-**-**'"/>
                    </#if>
                    </td>
                    <td>
                        <div class="error-message">
                        <@spring.showErrors "updateProfileForm.phoneNumber"/>
                        </div>
                    </td>
                </tr>
            </table>
            <div class="col-sm-5" class="button large round ">
                <input type="submit" value="Обновить информацию" class="button">
            </div>
        </form>
    </div>
    <h2>Ваши заказы</h2>
    <#if orders??>
    <div class="row recent_orders">
        <table>
            <tr>
                <th>
                    Номер заказа
                </th>
                <th>
                    Дата доставки
                </th>
                <th>
                    Дата отправки обратно
                </th>
                <th>
                    Статус
                </th>
            </tr>
            <#list orders as order>
             <tr>
                 <td>${order.id}</td>
                 <td>${order.dateOfDelivery}</td>
                 <td>${order.dateOfReturn}</td>
                 <#if order.status??>
                <td>${order.status}</td>
                 </#if>
             </tr>
            </#list>
        </table>
    </div>
    <#else>
    <p>Вы еще не делали заказов на нашем сайте</p>
    <p><a href="/library">Перейти к выбору книг</a></p>
    </#if>
</div>
<footer class="page-footer font-small unique-color-dark fixed-bottom">
    <div class="footer-copyright text-center py-3">© 2018 Copyright: Merenaas
    </div>
</footer>
</body>
</html>
