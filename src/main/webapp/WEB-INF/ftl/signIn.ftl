<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Вход</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="/assets/style/style.css">>
</head>
<body class="align">
    <div class="grid">
        <form method="post" class="form login" action="/signIn">
            <header class="login__header">
                <span>Войти</span>
            </header>
            <div class="login__body">
                <div class="form__field">
                    <input id="email" name="email" type="email" placeholder="Email" required>
                </div>
                <div class="error-message">

                </div>
                <div class="form__field">
                    <input type="password" name="password" placeholder="Пароль" required>
                </div>
                <div class="error-message">

                </div>
            </div>
            <footer class="login__footer">
                <input type="submit" value="Вход">
                <div class="ref_oth_pg">
                    <a href="/signUp">Регистрация</a>
                </div>
            </footer>
        </form>
    </div>
</body>
</html>
