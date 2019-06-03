<#import "../templates/main.ftl" as main/>
<@main.main title="Оформление заказа">
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
</@main.main>
