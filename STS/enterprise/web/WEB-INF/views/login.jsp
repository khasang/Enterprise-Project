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
					<h1>Авторизация пользователя</h1>
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
					</c:if>
					<form name='loginForm'
						  action="<c:url value='/login' />" method='POST'>

						<table>
							<tr>
								<td>User:</td>
								<td><input type='text' name='username'></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type='password' name='password' /></td>
							</tr>
							<tr>
								<td colspan='2'><input name="submit" type="submit"
													   value="submit" /></td>
							</tr>
						</table>

						<input type="hidden" name="${_csrf.parameterName}"
							   value="${_csrf.token}" />
					</form>
					<p><a href="<c:url value="/registration"/>">Create new Acount</a> </p>
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


