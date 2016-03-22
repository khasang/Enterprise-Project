<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Enterprise Solution</title>
		<link rel="stylesheet" type="text/css" href="../css/main.css">
	</head> 

	<body>
		<header class="top">
			<img id="headerLogo"
					 src="images/headerLogo.png" alt="Enterprise header logo image">
			<img id="headerSlogan"
					src="images/headerSlogan.png" alt="Слоган">
		</header>

		<nav id="privateArea">
			<ul>
				<li><a href=<c:url value='/login'/>>ЛИЧНЫЙ КАБИНЕТ</a></li>
			</ul>
		</nav>

		<nav id="publicArea">
			<ul>
				<li><a href="<c:url value='/index'/>">ГЛАВНАЯ</a></li>
				<li class="selected"><a href=<c:url value='/structure'/>>СТРУКТУРА</a></li>
				<li><a href=<c:url value='/services'/>>УСЛУГИ</a></li>
				<li><a href=<c:url value='/news'/>>НОВОСТИ И СТАТЬИ</a></li>
				<li><a href=<c:url value='/projects'/>>НАШИ ПРОЕКТЫ</a></li>
				<li><a href=<c:url value='/login'/>>ЗАКАЗАТЬ ПРОЕКТ</a></li>
				<li><a href=<c:url value='/contacts'/>>КОНТАКТЫ</a></li>
			</ul>
		</nav>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Структура организации</h1>
					<p>
						Список сотрудников с их реквизитами (должность, телефон, e-mail, и т.д.).
					</p>
					<h2>Динамическая HTML-страница</h2>
				</section>
				<section id="news">
					<a href=<c:url value='/news'/>><h1>ПОСЛЕДНИЕ НОВОСТИ</h1></a>
					<article>
						<header>
							<h2>Новость 1</h2>
							<time datetime="2016-03-09 12:00">9.03.2016 12:00</time>
						</header>
						<p>
							Содержимое новости 1
						</p>
					</article>
					<article>
						<header>
							<h2>Новость 2</h2>
							<time datetime="2016-03-09 16:00">9.03.2016 16:00</time>
						</header>
						<p>
							Содержимое новости 2
						</p>
					</article>
					<article>
						<header>
							<h2>Новость 3</h2>
							<time datetime="2016-03-09 23:20">9.03.2016 23:20</time>
						</header>
						<p>
							Содержимое новости 3
						</p>
					</article>
				</section>
			</div> <!-- mainRow -->
		</div> <!-- mainContainer -->

		<footer>
			&copy; 2016, Enterprise co.
		</footer>

	</body>
</html>


