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
            <h1 align="center">Tracking project ${trackingProject.title}</h1><br>
            <h2>Customer:</h2><p>${trackingProject.customer}</p>
            <h2>General project type:</h2><p>${trackingProject.projectBasis}</p>
            <div id="trackingTable" align="center">
                <section id="OrderPartOfTable">
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>Title</th>
                            <th>History</th>
                        </tr>
                        <c:forEach items="${ordersOfTrackingProject}" var="order">
                            <tr>
                                <td>${order.id}</td>
                                <td>${order.feature}</td>
                                <td><a href=<c:url value='/admin/projects/tracking/${trackingProject.id}/${order.id}/history'/>>Show history</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </section>
                <section id="ProgressPartOfTable">
                    <table border="1">
                        <caption><b>Last track of order</b></caption>
                        <tr>
                            <th>Description</th>
                            <th>Progress</th>
                        </tr>
                        <c:forEach items="${lastTrack}" var="lastrack">
                            <tr>
                                <td>${lastrack.description}</td>
                                <td align="center">${lastrack.progress} %</td>
                            </tr>
                        </c:forEach>
                    </table>
                </section>
            </div>
            <p><a href=<c:url value='/admin/projects/tracking'/>><< full tracking list</a></p>
        </section>
    </div>
</div>

<footer>
    &copy; 2016, Enterprise co.
</footer>

</body>
</html>


