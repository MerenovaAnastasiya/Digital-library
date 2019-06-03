<#import "templates/main.ftl" as main/>
<@main.main title="Страница с книгами">
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
            <a href="/addBook?isbn13=${book.isbn13}">
                <input type="submit" value="Заказать" class="button"">
            </a>
            </#if>
        </div>
    </div>
</div>
</@main.main>
