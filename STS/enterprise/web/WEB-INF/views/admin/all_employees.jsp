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
            <h1>Список всех работников</h1>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Логин</th>
                    <th>Адрес</th>
                    <th>Возраст</th>
                    <th>Департамен</th>
                    <th>Почта</th>
                    <th>Дата увольнения</th>
                    <th>Полное имя</th>
                    <th>Дата устройства</th>
                    <th>Зарплата</th>
                    <th>Налог</th>
                    <th>Enabled</th>
                </tr>
                <c:forEach items="${employee}" var="employee">
                    <tr>
                        <td>${employee.id}</td>
                        <td><a href=<c:url value='/admin/employee/${employee.login}'/>>${employee.login}</a></td>
                        <td>${employee.address}</td>
                        <td>${employee.age}</td>
                        <td>${employee.department}</td>
                        <td>${employee.email}</td>
                        <td>${employee.fireDate}</td>
                        <td>${employee.fullName}</td>
                        <td>${employee.hiredate}</td>
                        <td>${employee.salary}</td>
                        <td>${employee.tax}</td>
                        <td>${employee.enabled}</td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
            <p>
                <a href=<c:url value='/admin/organization'/>>НАЗАД</a> <br/>
            </p>
        </section>
        <section id="news">
            <jsp:include page="../fragments/newssection.jsp"/>
        </section>
    </div>
</div>

<footer>
    &copy; 2016, Enterprise co.
</footer>

</body>
</html>


