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
            <h1>Заказы для проекта ${project.title}</h1><br>
            <h2>Заказчик:</h2><p>${project.customer}</p>
            <h2><b>Статус:</b></h2>
            <p>
                <c:choose>
                    <c:when test="${project.endDate == null}">
                        В работе
                    </c:when>
                    <c:otherwise>
                        Закрыт: ${project.endDate}
                    </c:otherwise>
                </c:choose>
            </p>
            <h2><b>Список заказов:</b></h2>
            <c:forEach items="${ordersOfProject}" var="orders">
                <p>- ${orders}</p>
            </c:forEach><br>
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


