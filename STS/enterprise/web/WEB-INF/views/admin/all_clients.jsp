<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="../fragments/header.jsp"/>

<body>
<jsp:include page="adminNavigationBar.jsp"/>

<div id="mainContainer">
    <div id="mainRow">
        <section id="main">
            <h1>Список всех клиентов</h1>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Логин</th>
                    <th>Компания</th>
                    <th>Описание Компания</th>
                    <th>Контактное Лицо</th>
                    <th>Почта</th>
                    <th>Контактный Телефон</th>
                    <th>Enabled</th>
                </tr>
                <c:forEach items="${clients}" var="c">
                <tr>
                    <td>${c.id}</td>
                    <td><a href=<c:url value='/admin/client/${c.login}'/>>${c.login}</a></td>
                    <td>${c.companyName}</td>
                    <td>${c.companyDescription}</td>
                    <td>${c.contactPersonName}</td>
                    <td>${c.email}</td>
                    <td>${c.phoneNumber}</td>
                    <td>${c.enabled}</td>
                </tr>
                </c:forEach>
                </table>
                <br/>
                <p>
            <a href=<c:url value='/admin/account'/>>НАЗАД</a> <br/>
                </p>
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


