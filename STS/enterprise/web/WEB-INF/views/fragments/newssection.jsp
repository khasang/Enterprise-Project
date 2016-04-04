<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href=<c:url value='/news'/>><h1>ПОСЛЕДНИЕ НОВОСТИ</h1></a>

<c:forEach items="${news}" var="news">
    <article>
        <header>
            <h2>${news.title}</h2>
            <p>Дата: ${news.publishDate}</p>
        </header>
        <p>
            ${news.description}
        </p>
    </article>
</c:forEach>