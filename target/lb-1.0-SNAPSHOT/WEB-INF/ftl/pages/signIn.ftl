<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Вход</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="/style/style.css">
</head>

<body class="align">

<div class="grid">
    <form method="post" class="form login">
        <header class="login__header">
        </header>
        <div class="login__body">
            <div class="form__field">
                <input type="email" name="email" placeholder="<#if email??><#else>Email</#if>" <#if email??> value="${email}</#if>"
                       required>
            </div>
            <div class="error-message">
            <#if checkSignIn??>
                <#if checkSignIn == false>Неверный email или пароль
                </#if>
            </#if>
            </div>
            <div class="form__field">
                <input type="password" name="password" placeholder="Пароль" required style="margin-bottom: 20px">
            </div>
            <div class="form__field">
                <span>Запомнить меня </span><input type="checkbox" name="checkbox">
            </div>
        </div>


        <footer class="login__footer">
            <input type="submit" value="Войти">
            <p><a href="/signUp">Регистрация</a></p>
        </footer>
    </form>
</div>
</body>
</html>
