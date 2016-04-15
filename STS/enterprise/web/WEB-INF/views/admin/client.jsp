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
            <h1>Клиент</h1>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Логин</th>
                    <th>Компания</th>
                    <th>Описание Компания</th>
                    <th>Контактное Лицо</th>
                    <th>Почта</th>
                    <th>Контактный Телефон</th>
                    <th>Роли</th>
                    <th>Enabled</th>
                </tr>
                <tr>
                    <td>${client.id}</td>
                    <td>${client.login}</td>
                    <td>${client.companyName}</td>
                    <td>${client.companyDescription}</td>
                    <td>${client.contactPersonName}</td>
                    <td>${client.email}</td>
                    <td>${client.phoneNumber}</td>
                    <td>
                        <c:forEach items="${roles}" var="r">
                            ${r.role} &nbsp;&nbsp;
                        </c:forEach>
                    </td>
                    <td>${client.enabled}</td>
                </tr>
                <br/>
            </table>

            <c:choose>
                <c:when test="${client.enabled == 'true'}">
                    <a href=<c:url value='/admin/client/ban/${client.login}'/>><h2>BAN!</h2></a> <br/>
                </c:when>
                <c:otherwise>
                    <a href=<c:url value='/admin/client/unban/${client.login}'/>><h2>UNBAN!</h2></a> <br/>
                </c:otherwise>
            </c:choose>
            <p>
                <a href=<c:url value='/admin/all_clients'/>>НАЗАД</a> <br/>
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