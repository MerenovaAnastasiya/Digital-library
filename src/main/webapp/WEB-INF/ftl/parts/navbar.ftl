<header>
    <div class="row">
        <div class="logo">
            <a href="/main">Главная</a>
        </div>
        <nav id="main-nav-wrap">
            <ul class="main-navigation">
                <li><a href="/library">Библиотека</a></li>
                <li class="highlight with-sep">
                        <#if user??>
                            <a href="/profile" style="color: white">${user.login}</a>
                        <#else><a href="/signIn" title="">Войти</a></a></#if>
                </li>
            </ul>
        </nav>

        <a class="menu-toggle" href="#"><span>Menu</span></a>
    </div>
</header>