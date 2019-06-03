<#import "templates/main.ftl" as main/>
<@main.main title="Главная страница">
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
        </div>
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
            <h1>Новинки</h1>
        </div>
    </div>
    <div class="row books-row">
        <#list books as book>
            <div class="col-sm-12 col-lg-3  book-item">
                <a href="book?isbn13=${book.isbn13}"><img src="${book.path}"></a>
            </div>
        </#list>
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
                <h3>Вопрос 1</h3>
                <p>Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.
                    Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.</p>
            </div>
            <div class="bgrid">
                <h3>Вопрос 2</h3>
                <p>Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.
                    Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.</p>
            </div>
            <div class="bgrid">
                <h3>Вопрос 3</h3>
                <p>Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.
                    Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.</p>
            </div>
            <div class="bgrid">
                <h3>Вопрос 4</h3>

                <p>Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.
                    Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.</p>
            </div>
            <div class="bgrid">

                <h3>Вопрос 5</h3>

                <p>Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.
                    Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.</p>
            </div>
            <div class="bgrid">

                <h3>Вопрос 6</h3>
                <p>Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.
                    Ответ на вопрос. Ответ на вопрос. Ответ на вопрос. Ответ на вопрос.</p>
            </div>
        </div>
    </div>
</section>
</@main.main>
