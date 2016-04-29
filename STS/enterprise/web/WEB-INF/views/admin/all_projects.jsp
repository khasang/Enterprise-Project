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
                <h1>Список открытых проектов <br/></h1>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Project basis</th>
                    <th>Description</th>
                    <th>Customer</th>
                    <th>Price</th>
                    <th>Begin date</th>
                    <th>End date</th>
                    <th>Orders for project</th>
                </tr>
                <c:forEach items="${openProjects}" var="openProjects">
                    <tr>
                        <td>${openProjects.id}</td>
                        <td><a href=<c:url value='/admin/projects/${openProjects.id}'/>>${openProjects.title}</a></td>
                        <td>${openProjects.projectBasis}</td>
                        <td>${openProjects.description}</td>
                        <td>${openProjects.customer}</td>
                        <td>${openProjects.price}</td>
                        <td>${openProjects.beginDate}</td>
                        <td>Open</td>
                        <td><a href="<c:url value='/admin/all_projects/${openProjects.id}/orders'/>">Show orders</a> </td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
            <table align="center" border="1">
                <h1>Список выполненных проектов <br/></h1>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Project basis</th>
                    <th>Description</th>
                    <th>Customer</th>
                    <th>Price</th>
                    <th>Begin date</th>
                    <th>End date</th>
                    <th>Orders for project</th>
                </tr>
                <c:forEach items="${finishedProjects}" var="finishedProjects">
                    <tr>
                        <td>${finishedProjects.id}</td>
                        <td><a href=<c:url value='/admin/projects/${finishedProjects.id}'/>>${finishedProjects.title}</a></td>
                        <td>${finishedProjects.projectBasis}</td>
                        <td>${finishedProjects.description}</td>
                        <td>${finishedProjects.customer}</td>
                        <td>${finishedProjects.price}</td>
                        <td>${finishedProjects.beginDate}</td>
                        <td>${finishedProjects.endDate}</td>
                        <td><a href="<c:url value='/admin/all_projects/${finishedProjects.id}/orders'/>">Show orders</a> </td>
                    </tr>
                </c:forEach>
            </table>
            <p><a href=<c:url value='/admin/projects'/>><< back </a></p>
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
