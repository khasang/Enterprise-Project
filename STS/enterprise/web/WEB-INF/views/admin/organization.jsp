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
            <h1>CRUD по организации</h1>
            <p>
                <a href=<c:url value='/admin/all_employee'/>>Список всех сотрудников</a> <br/>
                <a href=<c:url value='/admin/find_employee'/>>Найти сотрудника</a> <br/>
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


