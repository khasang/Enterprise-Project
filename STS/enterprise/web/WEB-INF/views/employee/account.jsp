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
			<h1>Личный кабинет Работника</h1>
			<p>
				Курсы валют на ${currentDay} <br/>
				USD: ${USD} <br/>
				EUR: ${EUR} <br/>
				<br/>
			</p>
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


