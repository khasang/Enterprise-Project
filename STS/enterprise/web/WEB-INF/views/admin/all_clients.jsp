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
            <h1>Список всех клиентов</h1>
            <table border="1">
                <tr>
                    <th>Логин</th>
                    <th>Компания</th>
                    <th>Описание Компания</th>
                    <th>Контактное Имя</th>

                </tr>
                <tr>
                    <td>Ячейка 3</td>
                    <td>Ячейка 4</td>
                </tr>
                <br/>

                <p>
            <a href=<c:url value='/admin/account'/>>НАЗАД</a> <br/>
                </p>
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


