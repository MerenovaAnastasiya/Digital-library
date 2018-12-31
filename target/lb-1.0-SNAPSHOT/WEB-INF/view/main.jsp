<%--
  Created by IntelliJ IDEA.
  User: merenaas
  Date: 01.11.18
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<head>
    <meta charset="utf-8">
    <title>Lhander</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <%@ include file="styleAndJs.jsp" %>
</head>

<body id="top">
<t:navbar/>
<%--<header>--%>

    <%--<div class="row">--%>

        <%--<div class="logo">--%>
            <%--<a href="/main">Lhander</a>--%>
        <%--</div>--%>

        <%--<nav id="main-nav-wrap">--%>
            <%--<ul class="main-navigation">--%>
                <%--<li><a href="/library">Библиотека</a></li>--%>
                <%--<li class="highlight with-sep">--%>
                    <%--<c:if test="${(authorized == false) || (authorized == null)}"><a href="/signIn"--%>
                                                                                     <%--title="">Войти</a></c:if>--%>
                    <%--<c:if test="${authorized == true}"><a href="profile" style="color: white">${user.login}</a></c:if>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</nav>--%>

        <%--<a class="menu-toggle" href="#"><span>Menu</span></a>--%>

    <%--</div>--%>

<%--</header>--%>
<section id="intro">

    <div class="shadow-overlay"></div>

    <div class="intro-content">
        <div class="row">

            <div class="col-twelve">
                <h5>D-Library</h5>
                <h1>Мы возвращаем любовь к книгам</h1>
            </div>

        </div>
    </div>
</section>
<section id="process">

    <div class="row section-intro">
        <div class="col-twelve with-bottom-line">
            <h1>Как это работает?</h1>


        </div>
    </div>

    <div class="row process-content">

        <div class="left-side">

            <div class="item" data-item="1">

                <h5>Выбор книги</h5>

                <p>Регистрируетесь на сервисе, выбираете книги из нашей онлайн библиотеки любым удобным способом: по
                    названию, автору или жанру.</p>

            </div>

            <div class="item" data-item="2">

                <h5>Доставка</h5>

                <p>В течение дня курьер привозит Вам заказ. Мы доставляем книги по всему городу, стоимость доставки
                    можно узнать в личном кабинете.</p>

            </div>

        </div> <!-- /left-side -->

        <div class="right-side">

            <div class="item" data-item="3">

                <h5>Чтение</h5>

                <p>Наслаждаетесь чтением настоящей бумажной книги! Ведь это так прекрасно: запах страниц,
                    блабалабалбала</p>

            </div>

            <div class="item" data-item="4">

                <h5>Возврат книги</h5>

                <p>После прочтения книги в личном кабинете делаете заказ на возврат. В удобное для Вас время курьер
                    приезжает и забирает книгу в библиотеку.</p>

            </div>

        </div>

        <div class="image-part"></div>

    </div>

</section>
<section id="features">

    <div class="row section-intro">
        <div class="col-twelve with-bottom-line">


            <h1>Бестселлеры</h1>
        </div>
    </div>
    <div class="row books-row">
        <c:forEach items="${books}" var="book">
            <div class="col-sm-12 col-lg-3  book-item">
                <a href="book?name=${book.id}"><img src="${book.path}"></a>
            </div>
        </c:forEach>

    </div>

</section>
<section id="faq">

    <div class="row section-intro">
        <div class="col-twelve with-bottom-line">

            <h5>Faq</h5>
            <h1>вопросы и ответы</h1>

        </div>
    </div>

    <div class="row faq-content">

        <div class="q-and-a block-1-2 block-tab-full group">

            <div class="bgrid">

                <h3>Можно задать Вам вопрос?</h3>

                <p>Длинный текст - ответ на вопрос. В нем мы что-то обхясняем нашим дорогим клиентам. Этот сайт был создан самой замечательной девушкой на свете. И она получила максимальный балл по семестровке. О, да!</p>

            </div>

            <div class="bgrid">

                <h3>А можно еще один вопросик?</h3>

                <p>Длинный текст - ответ на вопрос. В нем мы что-то обхясняем нашим дорогим клиентам. Этот сайт был создан самой замечательной девушкой на свете. И она получила максимальный балл по семестровке. О, да!</p>

            </div>

            <div class="bgrid">

                <h3>А еще один? Ну, пожалуйста</h3>

                <p>Длинный текст - ответ на вопрос. В нем мы что-то обхясняем нашим дорогим клиентам. Этот сайт был создан самой замечательной девушкой на свете. И она получила максимальный балл по семестровке. О, да!</p>

            </div>

            <div class="bgrid">

                <h3>Ну, еще один. плиииз!</h3>

                <p>Длинный текст - ответ на вопрос. В нем мы что-то обхясняем нашим дорогим клиентам. Этот сайт был создан самой замечательной девушкой на свете. И она получила максимальный балл по семестровке. О, да!</p>

            </div>

            <div class="bgrid">

                <h3>Это точно последний вопрос. Обещаю</h3>

                <p>Длинный текст - ответ на вопрос. В нем мы что-то обхясняем нашим дорогим клиентам. Этот сайт был создан самой замечательной девушкой на свете. И она получила максимальный балл по семестровке. О, да!</p>

            </div>

            <div class="bgrid">

                <h3>Хотя, нет. Вот последний вопрос! Заказывайте уже книги!</h3>

                <p>Длинный текст - ответ на вопрос. В нем мы что-то обхясняем нашим дорогим клиентам. Этот сайт был создан самой замечательной девушкой на свете. И она получила максимальный балл по семестровке. О, да!</p>

            </div>

        </div>

    </div>
    <div class="row section-ads">

        <div class="col-twelve">

            <div class="ad-content">

                <h2 class="h01">Читайте с удовольствием</h2>

                <p class="lead">
                    Два шедевра Альбера Камю – роман «Чума» и пьеса «Недоразумение» – объединены темами свободы и
                    выбора, осознания человеком собственного бессилия перед лицом жестокого рока. Холодная хроника
                    эпидемии чумы в курортном алжирском городке превращается в трагическую и пугающую притчу о
                    смертельной опасности, пробуждающей в человеческой душе все лучшее – или худшее.
                </p>

                <div class="action">
                    <a class="button large round" href="/signUp">Регистрация</a>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="footer-bottom">

    <div class="row">

        <div class="col-twelve">
            <div class="copyright">
                <span>© Copyright</span>
                <span>DLibrary</span>
            </div>

        </div>

    </div>

</div>

<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/js/plugins.js"></script>
<script src="/js/main.js"></script>
</body>
</html>
