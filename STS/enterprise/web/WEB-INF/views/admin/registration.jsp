<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
</head>
<jsp:include page="../fragments/header.jsp"/>
<body>
<jsp:include page="adminNavigationBar.jsp"/>
<div id="mainContainer">
    <div id="mainRow">
        <section id="main">
            <form:form method="POST" action="/admin/registration/new_employee" modelAttribute="employee">
                <form:errors path="*" cssClass="errorblock" element="div"/>
                <table align="center" border="1" width="30%" cellpadding="5">
                    <thead>
                    <tbody>
                    <tr>
                        <td>Contact Person:</td>
                        <td><input path="fullName" type="text" name="fullName" value=""/>
                            <br><form:errors path="fullName" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Age:</td>
                        <td><input path="age" type="text" name="age" value=""/>
                            <br><form:errors path="age" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Contact Email:</td>
                        <td><input path="email" type="text" name="email" value=""/>
                            <br><form:errors path="email" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input path="address" type="text" name="address" value=""/>
                            <br><form:errors path="address" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Salary:</td>
                        <td>
                            <input path="salary" type="text" name="salary" value=""/>
                            <br><form:errors path="salary" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Hire Date:</td>
                        <td><input path="hiredate" name="hiredate" placeholder="yyyy-MM-dd" value=""/>
                            <br><form:errors path="hiredate" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Department:</td>
                        <td>
                            <form:select path="department">
                                <form:option value="DEVELOPMENT" label="DEVELOPMENT"/>
                                <form:option value="QA" label="QA"/>
                                <form:option value="MANAGEMENT" label="MANAGEMENT"/>
                                <form:option value="DESIGN" label="DESIGN"/>
                                <form:option value="TECHSUPPORT" label="TECHSUPPORT"/>
                                <form:option value="SYSTEMADMINISTRATION" label="SYSTEMADMINISTRATION"/>
                            </form:select>
                            <br><form:errors path="department" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Tax:</td>
                        <td><input path="tax" type="text" name="tax" value=""/>
                            <br><form:errors path="tax" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Login:</td>
                        <td><input path="login" type="text" name="login" value=""/>
                            <br><form:errors path="login" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input path="password" id="password" type="password" name="password" value=""/>
                            <br><form:errors path="password" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit"/></td>
                        <td><a href=<c:url value='/admin/account'/>>НАЗАД</a> <br/></td>
                    </tr>
                    </tbody>
                </table>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form:form>
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






