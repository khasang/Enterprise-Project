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
			КУРС USD: ${USD} <br/>
			КУРС EUR: ${EUR} <br/>
			<center>
				<a href=<c:url value='/admin/clients'/>>КЛИЕНТЫ</a> <br/>
				<a href=<c:url value='/admin/organization'/>>ОРГАНИЗАЦИЯ</a> <br/>
				<a href=<c:url value='/admin/registration'/>>НОВЫЙ СОТРУДНИК</a> <br/>
				<a href=<c:url value='/admin/projects'/>>ПРОЕКТЫ</a> <br/>
				<a href=<c:url value='/admin/news'/>>НОВОСТИ</a> <br/>
				<a href=<c:url value='/admin/finance'/>>ФИНАНСЫ</a> <br/>
			</center>
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


