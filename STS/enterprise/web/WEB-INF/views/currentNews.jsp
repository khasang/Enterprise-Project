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
                <h1>Новости и статьи</h1>
                <p>
                <h2>${news.title}</h2>
                </p>
                <p>
                    ${news.publishDate}<br/>
                </p>
                <p>
                    ${news.content}<br/>
                </p>
            <a href=<c:url value='/news'/>>НАЗАД</a> <br/>
        </section>
        <section id="news">
            <jsp:include page="fragments/newssection.jsp"/>
        </section>
    </div>
</div>

<footer>
    &copy; 2016, Enterprise co.
</footer>

</body>
</html>


