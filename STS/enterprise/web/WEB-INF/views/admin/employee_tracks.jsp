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
                REQUESTED Tracks of ${employee.login}:
            </p>
            <table border="1">
                <tr>
                    <th>Project</th>
                    <th>Order</th>
                    <th>Status</th>
                    <th>Description</th>
                    <th>Progress</th>
                </tr>
                <c:forEach items="${requestedTracks}" var="requestedTracks">
                    <tr>
                        <td><a href=<c:url value='/admin/projects/${requestedTracks.order.project.id}'/>>${requestedTracks.order.project.title}</a></td>
                        <td>${requestedTracks.order.feature}</td>
                        <td>${requestedTracks.trackStatus}</td>
                        <td>${requestedTracks.description}</td>
                        <td>${requestedTracks.progress} %</td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
            <p>
                CONFIRMED Tracks of ${employee.login}:
            </p>
            <table border="1">
                <tr>
                    <th>Project</th>
                    <th>Order</th>
                    <th>Status</th>
                    <th>Description</th>
                    <th>Progress</th>
                </tr>
                <c:forEach items="${confirmedTracks}" var="confirmedTracks">
                    <tr>
                        <td><a href=<c:url value='/admin/projects/${confirmedTracks.order.project.id}'/>>${confirmedTracks.order.project.title}</a></td>
                        <td>${confirmedTracks.order.feature}</td>
                        <td>${confirmedTracks.trackStatus}</td>
                        <td>${confirmedTracks.description}</td>
                        <td>${confirmedTracks.progress} %</td>
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