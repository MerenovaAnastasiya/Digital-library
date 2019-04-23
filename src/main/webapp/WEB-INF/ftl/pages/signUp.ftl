<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<head xmlns:form="http://java.sun.com/jsf/html">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Title</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link rel="stylesheet" href="/static/style/style.css">
</head>
<body class="align">
    <div class="grid">
        <form method="post" class="form login" action="/signUp">
            <@spring.bind "signUpForm"/>
            <header class="login__header">
                <span>Регистрация</span>
            </header>
            <div class="login__body">
                <div class="form__field">
                    <@spring.formInput "signUpForm.login" "placeholder='Логин'"/>
                </div>
                <div class="error-message">
                    <@spring.showErrors "signUpForm.login"/>
                </div>
                <div class="form__field">
                    <@spring.formInput "signUpForm.email" "placeholder='Email'"/>
                </div>
                <div class="error-message">
                     <@spring.showErrors "signUpForm.email"/>
                </div>
                <div class="form__field">
                    <@spring.formPasswordInput "signUpForm.password" "placeholder='Пароль'"/>
                </div>
                <div class="error-message">
                    <@spring.showErrors "signUpForm.password"/>
                </div>
            </div>
            <footer class="login__footer">
                <input type="submit" value="Регистрация">
                <div class="ref_oth_pg"><a href="/signIn">Авторизация</a></div>
            </footer>
        </form>
    </div>
</body>
</html>
