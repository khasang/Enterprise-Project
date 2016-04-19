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
            <h1>CRUD по клиентам</h1>
            <p>
                <a href=<c:url value='/admin/all_clients'/>>Список всех клиентов</a> <br/>
                <a href=<c:url value='/admin/find'/>>Найти клиента</a> <br/>
            </p>
            <a href=<c:url value='/admin/clients'/>>НАЗАД</a> <br/>
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


