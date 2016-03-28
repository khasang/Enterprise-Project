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
				<li class="selected"><a href="../manager/news.jsp">НОВОСТИ И СТАТЬИ</a></li>
				<li><a href="../manager/projects.jsp">НАШИ ПРОЕКТЫ</a></li>
				<li><a href="../manager/employ.jsp">НАНЯТЬ РАБОТНИКА</a></li>
				<li><a href="../manager/contacts.jsp">КОНТАКТЫ</a></li>
			</ul>
		</nav>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Новости и статьи</h1>
					<p>
						Менеджеру доступен раздел новостей для просмотра и публикации новых.
						<br>
						В начале страницы распологается форма ввода для публикации новой Новости или Статьи. Текст новости или статьи может содержать ссылочные и другие основные HTML-теги. Текст в БД должен сохраняться с тегами.
						<br>
						Это необходимо для дополнительного оформления статей и новостей, а так же внедрении в них ссылок на сторонние ресурсы.
						<br>
						В отличие от колонки "ПОСЛЕДНИЕ НОВОСТИ" содержит полный список новостей и статей с прокруткой.
						<br>
						Каждую новость или статью дополняют кнопки "Отредактировать" и "Удалить".
						<br>
						После каждого "Сохранить", страница обновляется.
						<br>
						<br>
						<br>
						<h1>Вопрос для обсуждения</h1>
						<b>Быть может как вариант оформить эту страницу как таблицу в БД, в которой можно напрямую редактировать, удалять и добавлять записи?</b>
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


