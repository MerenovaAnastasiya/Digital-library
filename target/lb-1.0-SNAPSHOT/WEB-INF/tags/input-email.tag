<%@tag description="email-input" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form__field">
    <input type="email" name="email" placeholder="<c:if test="${email == null}">Email</c:if>" value="${email}" required>
</div>