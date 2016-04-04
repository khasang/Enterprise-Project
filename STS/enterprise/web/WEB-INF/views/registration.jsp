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
					<form name="regForm" method="POST" action="/client/registration">
						<center>
							<table border="1" width="30%" cellpadding="5">
								<thead>
								<tr>
									<th colspan="2">Enter Information Here</th>
								</tr>
								</thead>
								<tbody>
								<%--<tr>--%>
									<%--<td>Full Name</td>--%>
									<%--<td><input type="text" name="fullname" value="" /></td>--%>
								<%--</tr>--%>
								<%--<tr>--%>
									<%--<td>Phone</td>--%>
									<%--<td><input type="text" name="phone" value="" /></td>--%>
								<%--</tr>--%>
								<%--<tr>--%>
								<%--<tr>--%>
									<%--<td>Company Name</td>--%>
									<%--<td><input type="text" name="companyName" value="" /></td>--%>
								<%--</tr>--%>
								<%--<tr>--%>
									<%--<td>Address</td>--%>
									<%--<td><input type="text" name="address" value="" /></td>--%>
								<%--</tr>--%>
								<tr>
									<td>Email</td>
									<td><input type="text" name="email" value="" /></td>
								</tr>
								<tr>
									<td>Login</td>
									<td><input type="text" name="login" value="" required="true" /></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><input type="password" name="password" value="" /></td>
								</tr>
								<%--<tr>--%>
									<%--<td>Confirm Password</td>--%>
									<%--<td><input type="password" name="confirmpass" value="" /></td>--%>
								<%--</tr>--%>
								<tr>
									<td><input type="submit" value="Submit" /></td>
									<td><input type="reset" value="Reset" /></td>
								</tr>
								<tr>
									<td colspan="2">already registered? <a href=<c:url value ='/login'/>>Login Here</a></td>
								</tr>
								</tbody>
							</table>
						</center>
						<input type="hidden" name="${_csrf.parameterName}"
							   value="${_csrf.token}" />
					</form>
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


