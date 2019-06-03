<#import "templates/main.ftl" as main/>
<@main.main title="Наша библиотека">
<div class="container library-container">
    <h2>Наша библиотека</h2>
    <div class="row books-row">
        <#list books as book>
            <div class="col-sm-12 col-lg-3 book-item">
                <a href="book?isbn13=${book.isbn13}"><img src="${book.path}"></a>
            </div>
        </#list>
    </div>
</div>
</@main.main>

