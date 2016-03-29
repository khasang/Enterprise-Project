<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<jsp:include page="../fragments/header.jsp"/>

	<body>
		<header class="top">
			<img id="headerLogo"
				 src="../resources/images/headerLogo.png" alt="Enterprise header logo image">
			<img id="headerSlogan"
				 src="../resources/images/headerSlogan.png" alt="Слоган">
		</header>

		<nav id="privateArea">
			<ul>
				<c:url value="/logout" var="logoutURL"/>
				<li><a href="${logoutURL}">ВЫХОД</a></li>
			</ul>
		</nav>

		<nav id="publicArea">
			<ul>
				<li><a href="../customer/customer.html">ЛИЧНЫЙ КАБИНЕТ</a></li>
				<li><a href="../customer/chat.html">ЧАТ</a></li>
				<li><a href="../customer/structure.html">СТРУКТУРА</a></li>
				<li><a href="../customer/news.html">НОВОСТИ И СТАТЬИ</a></li>
				<li><a href="../customer/order.html">ЗАКАЗАТЬ ПРОЕКТ</a></li>
				<li class="selected"><a href=<c:url value='/customer/contacts'/>>КОНТАКТЫ</a></li>
				<li><a href="/index">НА ГЛАВНУЮ</a></li>
			</ul>
		</nav>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Контакты организации</h1>
					<p>
						Основные контакты организации.
						<br>
						Адрес, телефоны для контактов, e-mail-ы, описание проезда к организации, карта Google Map/Yandex Map.
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


