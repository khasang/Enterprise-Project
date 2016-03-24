<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add New User</title>
</head>
<body>
    <form method="POST" action="/addUser">
        <tr>
            <td>ID</td>
            <td><input type="text" name="userId" value="" /></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="userName" value="" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="userEmail" value="" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </form>
</body>
</html>
