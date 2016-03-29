<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <jsp:include page="fragments/header.jsp"/>
    
    <body>
        <div id="mainContainer">
            <div id="mainRow">
                <h1>Error 403</h1> <br/>
                <h2>Недостаточно прав!</h2> <br/>
                <c:url value="/logout" var="redirect"/>
                <a href="${redirect}">Вернуться</a>
            </div>
        </div>
    </body>
</html>
