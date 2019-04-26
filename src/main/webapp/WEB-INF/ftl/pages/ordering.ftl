<#import "/spring.ftl" as spring />
<div class="container">
    <form method="post" action="/checkOut">
        <div class="row  mb-2">
            <div class="col-sm-2">
                <label for="address">
                    Адрес доставки *
                </label>
            </div>
            <div class="col-sm-5">
                <@spring.formInput "checkoutForm.address"/>
                <#--<input type="text" id="address" name="address">-->
            </div>
        </div>
       <div class="row">-->
        </div>
        <div class="row">
            <div class="col-sm-2">
                <label for="email">
                    Электронная почта
                </label>
            </div>
            <div class="col-sm-5">
                <@spring.formInput "checkoutForm.email"/>
                <#--<input type="email" id="email" name="email">-->
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2">
                <label for="comment">
                    Комментарий
                </label>
            </div>
            <div class="col-sm-5">
                <@spring.formInput "checkoutForm.comment"/>
                <#--<input type="tel" id="comment" name="comment" class="comment-input">-->
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