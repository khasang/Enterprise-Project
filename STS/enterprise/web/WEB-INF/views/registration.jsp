<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<jsp:include page="fragments/header.jsp"/>

	<body>
		<jsp:include page="fragments/navigationbar.jsp"/>

		<div id="mainContainer">
			<div id="mainRow">
				<section id="main">
					<%--<form method="post" action=<c:url value ='/regsuccess'/>>--%>
						<%--&lt;%&ndash;<center>&ndash;%&gt;--%>
							<%--<table align="center" border="1" width="30%" cellpadding="5">--%>
								<%--<thead>--%>
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
							<input id="id" name="id" type="hidden" value="0"/>
							<table>
								<tr>
									<td><label for="email">Email: </label> </td>
									<td><input id="email" name="email" type="text" value=""/></td>
									<td></td>
								</tr>

								<tr>
									<td><label for="login">Login: </label> </td>
									<td><input id="login" name="login" type="text" value=""/></td>
									<td></td>
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
						</form>
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


