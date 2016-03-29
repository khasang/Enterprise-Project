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
				<li class="selected"><a href="../employee/employee.jsp">ЛИЧНЫЙ КАБИНЕТ ИСПОЛНИТЕЛЯ</a></li>
				<li><a href="../employee/chat.jsp">ЧАТ</a></li>
				<li><a href="../employee/structure.jsp">СТРУКТУРА</a></li>
				<li><a href="../employee/news.jsp">НОВОСТИ И СТАТЬИ</a></li>
				<li><a href="../employee/projects.jsp">НАШИ ПРОЕКТЫ</a></li>
				<li><a href="../employee/contacts.jsp">КОНТАКТЫ</a></li>
			</ul>
		</nav>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Личный кабинет Исполнителя</h1>
					<p>
						Список заказов в системе с их реквизитами, назначенных на конкретного Исполнителя.
						<br>
						Можно организовать в виде 2-х таблиц.
						<br>
						В первой таблице список Заказов, находящихся в работе у Исполнителя, со следующими полями: Номер(наименование) заказа, Имя проекта заказа, Статус, Процент выполнения.
						<br>
						При выборе в первой таблице конкретного Заказа, во второй отображается история прогресса по заказу с соответсвующими descriprion. Исполнитель может добвать в историю фиксацию прогресса Заказа с указанием процента выполненных работ и заполнения соответсвующего description.
						<br>
						% выполнения заказа не может быть <= % из 1-ой таблицы. Новая отметка о выполненных работах формируется в БД со статусом "не подтверждена".
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


