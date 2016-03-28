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
				<li><a href="../manager/manager.jsp">ЛИЧНЫЙ КАБИНЕТ МЕНЕДЖЕРА</a></li>
				<li><a href="../manager/chat.jsp">ЧАТ</a></li>
				<li><a href="../manager/structure.jsp">СТРУКТУРА</a></li>
				<li><a href="../manager/news.jsp">НОВОСТИ И СТАТЬИ</a></li>
				<li><a href="../manager/projects.jsp">НАШИ ПРОЕКТЫ</a></li>
				<li><a href="../manager/employ.jsp">НАНЯТЬ РАБОТНИКА</a></li>
				<li class="selected"><a href="../manager/contacts.jsp">КОНТАКТЫ</a></li>
			</ul>
		</nav>

		<div id="mainContainer">
			<div id="mainRow">
				<section>
					<jsp:include page="../fragments/newssection.jsp"/>
				</section>
			</div> <!-- mainRow -->
		</div> <!-- mainContainer -->

		<footer>
			&copy; 2016, Enterprise co.
		</footer>

	</body>
</html>


