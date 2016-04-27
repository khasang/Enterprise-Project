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
            <h1 align="center">Tracking of active projects</h1><br>
            <table align="center" border="1">
                <tr>
                    <th>Title</th>
                    <th>General type</th>
                    <th>Description</th>
                    <th>Begin Date</th>
                    <th>Tracking</th>
                </tr>
                <c:forEach items="${runningProjects}" var="runningProjects">
                    <tr>
                        <td>${runningProjects.title}</td>
                        <td>${runningProjects.projectBasis}</td>
                        <td>${runningProjects.description}</td>
                        <td>${runningProjects.beginDate}</td>
                        <td><a href=<c:url value = '/admin/projects/tracking/${runningProjects.id}'/>>Track</a>
                    </tr>
                </c:forEach>
            </table>
            <p><a href=<c:url value='/admin/projects'/>><< back</a></p>
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


