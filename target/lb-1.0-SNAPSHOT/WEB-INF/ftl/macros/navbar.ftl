<header>
    <div class="row">
        <div class="logo">
            <a href="/main">Lhander</a>
        </div>

        <nav id="main-nav-wrap">
            <ul class="main-navigation">
                <li><a href="/library">Библиотека</a></li>
                <li class="highlight with-sep">
                    <#if authorized??>
                        <#if authorized == false><a href="/signIn" title="">Войти</a></#if>
                        <#if authorized == true><a href="profile" style="color: white">${user.login}</a></#if>
                    <#else><a href="/signIn" title="">Войти</a>
                    </#if>
                </li>
            </ul>
        </nav>

        <a class="menu-toggle" href="#"><span>Menu</span></a>

    </div>

</header>