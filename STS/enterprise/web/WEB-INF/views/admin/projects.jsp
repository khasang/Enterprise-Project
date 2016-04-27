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
            <h1>CRUD по проектам</h1>
            <p>
                <a href=<c:url value='/admin/all_projects'/>>Список всех проектов</a> <br/>
                <a href=<c:url value='/admin/projects/tracking'/>>Список рабочих проектов</a> <br/>
                <a href=<c:url value='/admin/em111ployee/id/projects'/>>Проекты сотрудника</a> <br/>
            </p>
            <a href=<c:url value='/admin/account'/>>НАЗАД</a> <br/>
        </section>
        <section id="news">
            <jsp:include page="../fragments/newssection.jsp"/>
        </section>
    </div> <!-- mainRow -->
</div> <!-- mainContainer -->

<footer>
    &copy; 2016, Enterprise co.
</footer>

</body>
</html>


