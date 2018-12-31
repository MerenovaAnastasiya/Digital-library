
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Title</title>
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
                    <input type="text" name="login" placeholder="<#if login??><#else>Логин</#if>" <#if login??>value="${login}"</#if> required>
                </div>
            <div class="error-message">
                <#if chekLogin??>
                <#if chekLogin == false>
                    Неверный формат логина
                </#if>
                </#if>
                <#if checkLoginForAvailability??>
                <#if checkLoginForAvailability == false>
                    Пользователь с таким логином уже существует
                </#if>
                </#if>
            </div>
                <div class="form__field">
                    <input type="email" name="email" placeholder="<#if email??>Email</#if>" value="${email}" required>
                </div>
            <div class="error-message">
                <#if chekEmail??>
                <#if chekEmail == false>
                    Неверный формат Email
                </#if>
                </#if>
                <#if checkEmailForAvailability??>
                <#if checkEmailForAvailability == false>
                    Пользователь с таким Email уже существует
                </#if>
                </#if>
            </div>
                <div class="form__field">
                    <input type="password" name="password" placeholder="Пароль" required style="margin-bottom: 20px">
                </div>
            <div class="error-message">
                <#if chekPassword??>
                <#if chekPassword == false>
                    Неверный формат пароля
                </#if>
                </#if>
            </div>
            <div class="form__field">
                <span>Запомнить меня </span><input type="checkbox" name="checkbox">
            </div>
        </div>
        <footer class="login__footer">
            <input type="submit" value="Регистрация">
        </footer>
    </form>
</div>
</body>
</html>
