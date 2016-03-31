<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<jsp:include page="fragments/header.jsp"/>

	<body>
		<jsp:include page="fragments/navigationbar.jsp"/>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Регистрация нового пользователя</h1>
					<p>
						Регистрация пользователя (Заказчика) с указание его реквизитов.
						<br>
						После регистрации пользователь перенаправляется в личный кабинет <a href=<c:url value='/client/account'/>>Заказчика</a>.
					</p>
					<h2>Статическая HTML-страница</h2>
				</section>
				<section id="news">
					<jsp:include page="fragments/newssection.jsp"/>
				</section>
			</div> <!-- mainRow -->
		</div> <!-- mainContainer -->

		<footer>
			&copy; 2016, Enterprise co.
		</footer>

	</body>
</html>


