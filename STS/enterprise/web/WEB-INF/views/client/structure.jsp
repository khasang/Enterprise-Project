<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<jsp:include page="../fragments/header.jsp"/>

	<body>
		<jsp:include page="clientNavigationBar.jsp"/>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Структура организации</h1>
					<p>
						Заказчику в ЛК доступен список сотрудников с их реквизитами (должность, телефон, e-mail, и т.д.).
					</p>
					<h2>Динамическая HTML-страница</h2>
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


