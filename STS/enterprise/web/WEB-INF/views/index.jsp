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
                <h1>Главная страница</h1>
                <p>
                    Содержимое главной страницы.
                    <br>
                    Сведения об организации.
                </p>
                <h2>Статическая HTML-страница</h2>
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


