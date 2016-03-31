<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<jsp:include page="../fragments/header.jsp"/>

	<body>
		<jsp:include page="clientNavigationBar.jsp"/>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Личный кабинет Заказчика</h1>
					<p>
						Список заказов Заказчика с их реквизитами.
						<br>
						Можно организовать в виде 2-х таблиц.
						<br>
						В первой таблице список Заказов со следующими полями: Номер(наименование) заказа, Имя проекта заказа, процент выполнения.
						<br>
						При выборе в первой таблице конкретного Заказа, во второй отображается история прогресса по заказу с соответсвующими descriprion.
						<br>
						Заказы из первой таблицы с прогрессом 100% Заказчик может подтвердить.
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


