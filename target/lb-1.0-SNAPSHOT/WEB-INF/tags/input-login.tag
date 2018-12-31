<%@tag description="login-input" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form__field">
    <input type="text" name="login" placeholder="<c:if test="${login == null}">Логин</c:if>" value="${login}" required>
</div>