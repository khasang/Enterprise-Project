<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="../fragments/header.jsp"/>

<body>
<jsp:include page="employeeNavigationBar.jsp"/>

<div id="mainContainer">
    <div id="mainRow">
        <section id="main">
            <h1 align="center">New track for "${orderOfProject.feature}" of ${trackingProject.title}</h1><br>
            <form:form id="trackForm" method="POST" action="/employee/tracking/${trackingProject.id}/${orderOfProject.id}/create" modelAttribute="track">
                <table align="center" border="1" width="30%" cellpadding="5">
                    <thead>
                    <tr>
                        <th colspan="2">Enter track info</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Description</td>
                        <td><input path="description" type="text" name="description" value=""/></td>
                    </tr>
                    <tr>
                        <td>Progress</td>
                        <td><input path="progress" type="text" name="progress" value=""/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Create"/></td>
                        <td><input type="reset" value="Reset"/></td>
                    </tr>
                    </tbody>
                </table>
            </form:form>
            <td><a href="/employee/tracking/${trackingProject.id}"><< back to tracking table</a>
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