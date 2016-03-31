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
				<li><a href="../employee/employee.jsp">ЛИЧНЫЙ КАБИНЕТ ИСПОЛНИТЕЛЯ</a></li>
				<li><a href="../employee/chat.jsp">ЧАТ</a></li>
				<li><a href="../employee/structure.jsp">СТРУКТУРА</a></li>
				<li><a href="../employee/news.jsp">НОВОСТИ И СТАТЬИ</a></li>
				<li class="selected"><a href="../employee/projects.jsp">НАШИ ПРОЕКТЫ</a></li>
				<li><a href="../employee/contacts.jsp">КОНТАКТЫ</a></li>
			</ul>
		</nav>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Наши проекты</h1>
					<p>
						Презентации выполненных проектов.
						<br>
						Описания проектов со ссылками на рабочий сайт/приложение в Store.
					</p>
					<h2>Статическая HTML-страница</h2>
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


