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
                    <th>Id</th>
                    <th>Full name</th>
                    <th>Address</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Hire date</th>
                </tr>
                <tr>
                    <td>${accountData.id}</td>
                    <td>${accountData.fullName}</td>
                    <td>${accountData.address}</td>
                    <td>${accountData.age}</td>
                    <td>${accountData.email}</td>
                    <td>${accountData.hiredate}</td>
                </tr>
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


