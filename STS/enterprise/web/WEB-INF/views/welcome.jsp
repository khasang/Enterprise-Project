<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="fragments/header.jsp"/>

<body>
<jsp:include page="fragments/navigationbar.jsp"/>

<div id="mainContainer">
    <div id="mainRow">
        <section id="main">
            <center>
                <h1>Registration successfully complete!</h1> <br/>
                <h2>Go to my account</h2> <br/>
                <a href="<c:url value="/client/account"/>">My account</a>
            </center>
        </section>
        <section id="news">
            <jsp:include page="fragments/newssection.jsp"/>
        </section>
    </div> <!-- mainRow -->
</div> <!-- mainContainer -->

<footer>
    &copy; 2016, Enterprise co.
</footer>

</body>
</html>