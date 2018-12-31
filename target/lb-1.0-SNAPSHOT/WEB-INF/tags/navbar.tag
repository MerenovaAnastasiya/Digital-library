<%@tag description="navbar" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
    <div class="row">
        <div class="logo">
            <a href="/main">Lhander</a>
        </div>

        <nav id="main-nav-wrap">
            <ul class="main-navigation">
                <li><a href="/library">Библиотека</a></li>
                <li class="highlight with-sep">
                    <c:if test="${(authorized == false) || (authorized == null)}"><a href="/signIn"
                                                                                     title="">Войти</a></c:if>
                    <c:if test="${authorized == true}"><a href="profile" style="color: white">${user.login}</a></c:if>
                </li>
            </ul>
        </nav>

        <a class="menu-toggle" href="#"><span>Menu</span></a>

    </div>

</header>