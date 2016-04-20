<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="../fragments/header.jsp"/>

<body>
<jsp:include page="adminNavigationBar.jsp"/>

<div id="mainContainer">
    <div id="mainRow">
        <section id="main">
            <c:if test="${not empty error}">
                <div class="error">${error.message}</div>
            </c:if>
            <form method="POST" action="/admin/employee/{login}">
                <table>
                    <tr>
                        <td>Введите Логин Сотрудника <br/></td>
                        <td><input type='text' name='login'></td>
                    </tr>
                    <br/>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit"
                                               value="submit"/></td>
                    </tr>
                    <br/>
                </table>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>
            <a href=<c:url value='/admin/organization'/>>НАЗАД</a> <br/>
        </section>
        <section id="news">
            <jsp:include page="../fragments/newssection.jsp"/>
        </section>
    </div> <!-- mainRow -->
</div> <!-- mainContainer -->
<footer>
    &copy; 2016, Enterprise co.
</footer>
</body>
</html>


