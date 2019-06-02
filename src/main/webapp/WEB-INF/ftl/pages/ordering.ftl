<#import "/spring.ftl" as spring />
<div class="container">
    <form method="post" action="/checkOut">
        <div class="row  mb-2">
            <div class="col-sm-2">
                <label>
                    Адрес доставки *
                </label>
            </div>
            <div class="col-sm-5">
                <@spring.formInput "checkoutForm.address"/>
            </div>
        </div>
       <div class="row">-->
        </div>
        <div class="row">
            <div class="col-sm-2">
                <label>
                    Электронная почта
                </label>
            </div>
            <div class="col-sm-5">
                <@spring.formInput "checkoutForm.email"/>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2">
                <label>
                    Комментарий
                </label>
            </div>
            <div class="col-sm-5">
                <@spring.formInput "checkoutForm.comment"/>
            </div>
        </div>
        <p>TTTTTTT</p>
        <div class="row">
            <div class="col-sm-2">
                <label>
                    Дата возврата
                </label>
            </div>
            <div class="col-sm-5">
                <@spring.formInput "checkoutForm.datedOfDelivery"/>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2">
                <label>
                    Дата доставки
                </label>
            </div>
            <div class="col-sm-5">
                <@spring.formInput "checkoutForm.dateOfReturn"/>
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