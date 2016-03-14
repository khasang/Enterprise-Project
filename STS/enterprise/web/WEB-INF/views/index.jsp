<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My First Spring App</title>
</head>
<body>
<h1>Employee experience</h1>
<c:if test="${not empty lists}">

    <ul>
        <c:forEach var="exp" items="${exp}">
            <li>experience: ${exp}</li>
        </c:forEach>
    </ul>
</c:if>


</body>
</html>