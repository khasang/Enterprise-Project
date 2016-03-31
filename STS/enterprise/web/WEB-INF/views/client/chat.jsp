<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
				<li><a href="../client/account.html">ЛИЧНЫЙ КАБИНЕТ</a></li>
				<li class="selected"><a href=<c:url value='/client/chat'/>>ЧАТ</a></li>
				<li><a href="../client/structure.html">СТРУКТУРА</a></li>
				<li><a href="../client/news.html">НОВОСТИ И СТАТЬИ</a></li>
				<li><a href="../client/order.html">ЗАКАЗАТЬ ПРОЕКТ</a></li>
				<li><a href="../client/contacts.html">КОНТАКТЫ</a></li>
				<li><a href="/index">НА ГЛАВНУЮ</a></li>
			</ul>
		</nav>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Чат с менеджером</h1>
					<p>
						Форма чата.
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


