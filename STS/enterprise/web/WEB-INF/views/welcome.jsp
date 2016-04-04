<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="fragments/header.jsp"/>

<body>
<div id="mainContainer">
	<div id="mainRow">
		<h1>REgistration complete</h1> <br/>
		<h2>Go to my account</h2> <br/>
		<a href="<c:url value="/client/account"/>">My account</a>
	</div>
</div>
</body>
</html>