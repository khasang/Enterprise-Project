<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <script src="js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $.ajax({
                url: "http://localhost:8080/confidential/hello/news"
            }).then(function(data) {
                $('#service').append(data);
            });
        });
    </script>
    <title>Hello World</title>
</head>
<body>
<header>
    <h1>Title : ${title}</h1>
</header>
<section>
    <h1>Message : ${message}</h1>
</section>
<div>Get <a href="protected">protected</a> resource for admin.</div>
<div>Get <a href="confidential">confidential</a> resource for superadmin.</div>
<div id="service"><b>Результат обращения к сервису:</b> </div>
<c:forEach items="${viewproducts}" var="productorder">
    <tr>
        <td><c:out value="${productorder.ID}"/></td>
        <td><c:out value="${productorder.pname}"/></td>
        <td>100</td>
    </tr>
</c:forEach>
</body>
</html>