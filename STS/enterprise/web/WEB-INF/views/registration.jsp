<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<style>
		.error {
			color: #ff0000;
		}

		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
	</style>
</head>
	<jsp:include page="fragments/header.jsp"/>

	<body>
		<jsp:include page="fragments/navigationbar.jsp"/>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<form:form method="POST" action="/reg/registration" modelAttribute="client">
						<form:errors path="*" cssClass="errorblock" element="div" />
						<center>
							<table border="1" width="30%" cellpadding="5">
								<thead>
								<%--<tr>--%>
									<%--<th colspan="2">Enter Information Here</th>--%>
								<%--</tr>--%>
								<%--</thead>--%>

								<%--<tbody>--%>
								<%--<tr>--%>
									<%--<td>Email</td>--%>
									<%--<td><input type="text" name="email" value="" /></td>--%>
								<%--</tr>--%>
								<%--<tr>--%>
									<%--<td>Login</td>--%>
									<%--<td><input type="text" name="login" value="" /></td>--%>
								<%--</tr>--%>
								<%--<tr>--%>
									<%--<td>Password</td>--%>
									<%--<td><input type="password" name="password" value="" /></td>--%>
								<%--</tr>--%>
								<%--<tr>--%>
									<%--<td><input type="submit" value="Submit" /></td>--%>
								<%--</tr>--%>
								<%--<tr>--%>
									<%--<td colspan="2">Already have account? <a href=<c:url value ='/login'/>>Login Here</a></td>--%>
								<%--</tr>--%>
								<%--</tbody>--%>
							<%--</table>--%>
						<%--&lt;%&ndash;</center>&ndash;%&gt;--%>
					<%--</form>--%>
						<form id="client" action="<c:url value ='/regsuccess'/>" method="POST">
							<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
							<table>
								<tr>
									<td>Email</td>
									<td><input path="email" type="text" name="email" />
										<br><form:errors path="email" cssClass="error" />
									</td>
								</tr>
								<tr>
									<td>Login</td>
									<td><input path="login" type="text" name="login" value="" />
										<br><form:errors path="login" cssClass="error"/>
									</td>
								</tr>

								<tr>
									<td>Password</td>
									<td><input path="password" type="password" name="password" value="" />
										<br><form:errors path="password" cssClass="error"/>
									</td>
								</tr>

								<tr>
									<td><label for="password">Password: </label> </td>
									<td><input id="password" name="password" type="text" value=""/></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="3">
										<input type="submit" value="Register"/>
									</td>
								</tr>
							</table>
						</center>
						<input type="hidden" name="${_csrf.parameterName}"
							   value="${_csrf.token}" />
					</form:form>
				</section>
				<section id="news">
					<jsp:include page="fragments/newssection.jsp"/>
				</section>
			</div>
		</div>

		<footer>
			&copy; 2016, Enterprise co.
		</footer>

	</body>
</html>


