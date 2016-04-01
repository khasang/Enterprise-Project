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
					<form method="post" action="${pageContext.request.contextPath}client/createAccount" commandName="customer">
						<center>
							<table border="1" width="30%" cellpadding="5">
								<thead>
								<tr>
									<th colspan="2">Enter Information Here</th>
								</tr>
								</thead>
								<tbody>
								<tr>
									<td>First Name</td>
									<td><input type="text" name="fname" value="" /></td>
								</tr>
								<tr>
									<td>Last Name</td>
									<td><input type="text" name="lname" value="" /></td>
								</tr>
								<tr>
									<td>Phone</td>
									<td><input type="text" name="phone" value="" /></td>
								</tr>
								<tr>
									<td>Email</td>
									<td><input type="text" name="email" value="" /></td>
								</tr>
								<tr>
									<td>Address</td>
									<td><input type="text" name="address" value="" /></td>
								</tr>
								<tr>
									<td>Login</td>
									<td><input type="text" name="login" value="" /></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><input type="password" name="pass" value="" /></td>
								</tr>
								<tr>
									<td>Confirm Password</td>
									<td><input type="password" name="confirmpass" value="" /></td>
								</tr>
								<tr>
									<td><input type="submit" value="Submit" /></td>
									<td><input type="reset" value="Reset" /></td>
								</tr>
								<tr>
									<td colspan="2">Already registered!! <a href=<c:url value ='/login'/>>Login Here</a></td>
								</tr>
								</tbody>
							</table>
						</center>
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


