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
				<li><a href="../customer/customer.jsp">ЛИЧНЫЙ КАБИНЕТ ЗАКАЗЧИКА</a></li>
				<li><a href="../customer/chat.jsp">ЧАТ</a></li>
				<li><a href="../customer/structure.jsp">СТРУКТУРА</a></li>
				<li class="selected"><a href="../customer/news.jsp">НОВОСТИ И СТАТЬИ</a></li>
				<li><a href="../customer/order.jsp">ЗАКАЗАТЬ ПРОЕКТ</a></li>
				<li><a href="../customer/contacts.jsp">КОНТАКТЫ</a></li>
			</ul>
		</nav>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Новости и статьи</h1>
					<p>
						Заказчику доступен раздел новостей.
						<br>
						В отличие от колонки "ПОСЛЕДНИЕ НОВОСТИ" содержит полный список новостей и статей с прокруткой. 
					</p>
					<h2>Динамическая HTML-страница</h2>
				</section>
				<section id="news">
					<a href="../customer/news.jsp"><h1>ПОСЛЕДНИЕ НОВОСТИ</h1></a>
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


