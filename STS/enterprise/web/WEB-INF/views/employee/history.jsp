<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="../fragments/header.jsp"/>

<body>
<jsp:include page="employeeNavigationBar.jsp"/>

<div id="mainContainer">
    <div id="mainRow">
        <section id="main">
            <h1 align="center">Order "${orderOfProject.feature}" tracks history of ${trackingProject.title}</h1><br>
            <h2>Customer:</h2><p>${trackingProject.customer}</p>
            <h2>General project type:</h2><p>${trackingProject.projectBasis}</p>
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Implementor</th>
                    <th>Status</th>
                    <th>Description</th>
                    <th>Progress</th>
                </tr>
                <c:forEach items="${allTracks}" var="track">
                    <tr>
                        <td>${track.id}</td>
                        <td>${track.employee.fullName}</td>
                        <td>${track.trackStatus}</td>
                        <td>${track.description}</td>
                        <td>${track.progress} %</td>
                    </tr>
                </c:forEach>
            </table>
            <h2 id="new-track-ref"><a href=<c:url value='/employee/tracking/${trackingProject.id}/${orderOfProject.id}/input_track'/>>New track</a></h2>
            <p><a href=<c:url value='/employee/tracking/${trackingProject.id}'/>><< back to orders</a></p>
            <p><a href=<c:url value='/employee/mytasks'/>><< show tasks</a></p>
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