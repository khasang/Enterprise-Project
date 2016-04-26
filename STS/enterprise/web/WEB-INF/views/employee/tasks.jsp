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
                    <table border="1">
                        <tr>
                            <th>Project</th>
                            <th>Order</th>
                            <th>Status</th>
                            <th>Description</th>
                            <th>Progress</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach items="${tasks}" var="task">
                            <tr>
                                <td>${task.order.project.title}</td>
                                <td>${task.order.feature}</td>
                                <td>${task.trackStatus}</td>
                                <td>${task.description}</td>
                                <td>${task.progress} %</td>
                                <td><a href=<c:url value = '/employee/tracking/${task.order.project.id}/${task.order.id}/history'/>>Continue work</a></td>
                            </tr>
                        </c:forEach>
                    </table>
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


