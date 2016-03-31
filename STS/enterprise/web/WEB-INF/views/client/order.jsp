<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<jsp:include page="../fragments/header.jsp"/>

	<body>
		<jsp:include page="clientNavigationBar.jsp"/>
		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Заказ нового проекта</h1>
					<p>
						На странице доступна форма для заполнения реквизитов нового Заказа.
					</p>
					<h2>Статическая HTML-страница с формой ввода</h2>
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


