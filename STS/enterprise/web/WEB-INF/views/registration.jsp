<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <form:errors path="*" cssClass="errorblock" element="div"/>
                <center>
                    <table border="1" width="30%" cellpadding="5">
                        <thead>
                        <tr>
                            <th colspan="2">Enter Information Here</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Contact Person</td>
                            <td><input path="contactPersonName" type="text" name="contactPersonName" value=""/>
                                <br><form:errors path="contactPersonName" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Company Name</td>
                            <td><input path="companyName" type="text" name="companyName" value=""/>
                                <br><form:errors path="companyName" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Company Description</td>
                            <td><input path="companyDescription" type="text" name="companyDescription" value=""/>
                                <br><form:errors path="companyDescription" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Phone Number</td>
                            <td><input path="phoneNumber" type="text" name="phoneNumber" value=""/>
                                <br><form:errors path="phoneNumber" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Contact Email</td>
                            <td><input path="email" type="text" name="email"/>
                                <br><form:errors path="email" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Login</td>
                            <td><input path="login" type="text" name="login" value=""/>
                                <br><form:errors path="login" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td><input path="password" type="password" name="password" value=""/>
                                <br><form:errors path="password" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Confirm Password</td>
                            <td><input type="password" name="confirmpass" value=""/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Submit"/></td>
                            <td><input type="reset" value="Reset"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">already registered? <a href=<c:url value='/login'/>>Login Here</a></td>
                        </tr>
                        </tbody>
                    </table>
                </center>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form:form>
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
