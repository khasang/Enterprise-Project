<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="../fragments/header.jsp"/>

<body>
<jsp:include page="adminNavigationBar.jsp"/>


<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<h1>Чат</h1>
					<p>
						Концепция чата представлена в отдельном документе.
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


