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
            <h1>Сотрудник</h1>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Логин</th>
                    <th>Пароль</th>
                    <th>Адрес</th>
                    <th>Возраст</th>
                    <th>Департамен</th>
                    <th>Почта</th>
                    <th>Дата увольнения</th>
                    <th>Полное имя</th>
                    <th>Дата устройства</th>
                    <th>Зарплата</th>
                    <th>Налог</th>
                    <th>Роли</th>
                    <th>Tracks</th>
                    <th>Enabled</th>
                </tr>
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.login}</td>
                    <td>${employee.password}</td>
                    <td>${employee.address}</td>
                    <td>${employee.age}</td>
                    <td>${employee.department}</td>
                    <td>${employee.email}</td>
                    <td>${employee.fireDate}</td>
                    <td>${employee.fullName}</td>
                    <td>${employee.hiredate}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.tax}</td>
                    <td>
                        <c:forEach items="${roles}" var="r">
                            ${r.role} &nbsp;&nbsp;
                        </c:forEach>
                    </td>
                    <td><a href=<c:url value='/admin/employee/${employee.login}/tracks'/>>Tracks</a></td>
                    <td>${employee.enabled}</td>
                </tr>
                <br/>
            </table>

            <c:choose>
                <c:when test="${employee.enabled == 'true'}">
                    <a href=<c:url value='/admin/employee/ban/${employee.login}'/>><h2>BAN!</h2></a> <br/>
                </c:when>
                <c:otherwise>
                    <a href=<c:url value='/admin/employee/unban/${employee.login}'/>><h2>UNBAN!</h2></a> <br/>
                </c:otherwise>
            </c:choose>
            <p>
                <a href=<c:url value='/admin/organization'/>>НАЗАД</a> <br/>
            </p>
            </form>
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