
<div class="container">
    <form method="post" action="/checOut">
        <div class="row">
            <div class="col-sm-2">
                <label for="address">
                    Адрес доставки *
                </label>
            </div>
            <div class="col-sm-5">
                <input type="text" id="address" name="address">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2">
                <label for="date">
                    Дата *
                </label>
            </div>
            <div class="col-sm-5">
                <input type="date" id="date" name="date">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2">
                <label for="first-name">
                    Имя *
                </label>
            </div>
            <div class="col-sm-5">
                <input type="text" id="first-name" name="first-name" required>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2">
                <label for="last-name">
                    Фамилия *
                </label>
            </div>
            <div class="col-sm-5">
                <input type="text" id="last-name" name="last-name" required>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2">
                <label for="phone">
                    Телефон *
                </label>
            </div>
            <div class="col-sm-5">
                <input type="tel" id="phone" name="phone" required>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2">
                <label for="email">
                    Электронная почта
                </label>
            </div>
            <div class="col-sm-5">
                <input type="email" id="email" name="email">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2">
                <label for="comment">
                    Комментарий
                </label>
            </div>
            <div class="col-sm-5">
                <input type="tel" id="comment" name="comment" class="comment-input">
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