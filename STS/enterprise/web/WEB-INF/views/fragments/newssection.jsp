<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href=<c:url value='/news'/>><h1>ПОСЛЕДНИЕ НОВОСТИ</h1></a>

<div>
    <h2 id="news_title"></h2>
    <p id="news_content"></p>
</div>
<script src="/resources/js/jquery-2.2.2.min.js"></script>
<script>
    $.ajax({
        url: '/api/news_service/1',
        data: [],
        type: 'GET',
        crossDomain: false,
        dataType: 'json',
        success: function(data) {
            console.log(data);
            $('#news_title').text(data.title);
            $('#news_content').text(data.content);

        },
        error: function() { alert('Failed!'); },
    });
</script>