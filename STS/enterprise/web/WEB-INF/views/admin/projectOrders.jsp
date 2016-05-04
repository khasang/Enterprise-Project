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
            <table align="center" border="1">
                <h1>Orders of project: ${project.title} <br/></h1>
                <tr>
                    <th>Id</th>
                    <th>Order</th>
                    <th>Customer</th>
                    <th>Status</th>
                    <th>Tracks</th>
                </tr>
                <tr>
                    <c:forEach items="${ordersOfProject}" var="order">
                    <td>${order.id}</td>
                    <td>${order.feature}</td>
                    <td><a href="<c:url value='/admin/client/${project.customer.login}'/>">${project.customer}</a> </td>
                    <td>
                        <c:choose>
                            <c:when test="${project.endDate == null}">
                                В работе
                            </c:when>
                            <c:otherwise>
                                Закрыт: ${project.endDate}
                            </c:otherwise>
                        </c:choose>
                    </td>
                        <td><a href=<c:url value='/admin/project/${project.id}/order/${order.id}/tracks'/>>Tracks</a></td>
                </tr>
                </c:forEach>
            </table>
            <p><a href=<c:url value='/admin/all_projects'/>><< к списку проектов</a></p>
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


