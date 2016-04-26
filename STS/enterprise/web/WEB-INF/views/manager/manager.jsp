<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<jsp:include page="../fragments/header.jsp"/>

	<body>
		<header class="top">
			<img id="headerLogo"
					 src="../images/headerLogo.png" alt="Enterprise header logo image">
			<img id="headerSlogan"
					src="../images/headerSlogan.png" alt="Слоган">
		</header>

		<nav id="privateArea">
			<ul>
				<li><a href="../index.jsp">ВЫХОД</a></li>
			</ul>
		</nav>

		<nav id="publicArea">
			<ul>
				<li class="selected"><a href="../manager/manager.jsp">ЛИЧНЫЙ КАБИНЕТ МЕНЕДЖЕРА</a></li>
				<li><a href="../manager/chat.jsp">ЧАТ</a></li>
				<li><a href="../manager/structure.jsp">СТРУКТУРА</a></li>
				<li><a href="../manager/news.jsp">НОВОСТИ И СТАТЬИ</a></li>
				<li><a href="../manager/proects.jsp">НАШИ ПРОЕКТЫ</a></li>
				<li><a href="../manager/employ.jsp">НАНЯТЬ РАБОТНИКА</a></li>
				<li><a href="../manager/contacts.jsp">КОНТАКТЫ</a></li>
			</ul>
		</nav>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Личный кабинет Менеджера</h1>
					<p>
						Список заказов в системе с их реквизитами.
						<br>
						Можно организовать в виде 2-х таблиц.
						<br>
						В первой таблице список Заказов со следующими полями: Номер(наименование) заказа, Имя проекта заказа, Статус, Процент выполнения. Предусмотреть фильтрацию по Статусу (скрывать/показывать закрытые Заказы). Функционал передачи в работу Заказа конкретному работнику (должен быть виден список работников).
						<br>
						При выборе в первой таблице конкретного Заказа, во второй отображается история прогресса по заказу с соответсвующими descriprion. Каждый из decription может иметь 2 статуса: не подтвержден и подтвержден Менеджером. Нужен функционал "подтверждения".
						<br>
						Только подтвержденные decriptions отображаются в ЛК Заказчика.
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


