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
            <p>
                Tracks of ${employee.login}:
            </p>
            <table border="1">
                <tr>
                    <th>Project</th>
                    <th>Order</th>
                    <th>Status</th>
                    <th>Description</th>
                    <th>Progress</th>
                </tr>
                <c:forEach items="${tracks}" var="tracks">
                    <tr>
                        <td>${tracks.order.project.title}</td>
                        <td>${tracks.order.feature}</td>
                        <td>${tracks.trackStatus}</td>
                        <td>${tracks.description}</td>
                        <td>${tracks.progress} %</td>
                    </tr>
                </c:forEach>
            </table>
            <p>
                <a href=<c:url value='/admin/all_employee'/>>НАЗАД</a> <br/>
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