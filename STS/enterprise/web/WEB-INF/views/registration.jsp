<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <script src="js/jquery-2.2.2.min.js"></script>
    <script type="text/javascript">
        function onLoad() {

            $("#password").keyup(checkPasswordsMatch);
            $("#confirmpass").keyup(checkPasswordsMatch);

            $("#details").submit(canSubmit);
        }

        function canSubmit() {
            var password = $("#password").val();
            var confirmpass = $("#confirmpass").val();

            if (password != confirmpass) {
                alert("PASSWORDS DO NOT MATCH. PLEASE TRY AGAIN.")
                return false;
            }
            else {
                return true;
            }
        }

        function checkPasswordsMatch() {
            var password = $("#password").val();
            var confirmpass = $("#confirmpass").val();

            if (password.length > 3 || confirmpass.length > 3) {

                if (password == confirmpass) {
                    $("#matchpass").text("Passwords match.");
                    $("#matchpass").addClass("valid");
                    $("#matchpass").removeClass("error");
                } else {
                    $("#matchpass").text("Passwords do not match.");
                    $("#matchpass").addClass("error");
                    $("#matchpass").removeClass("valid");
                }
            }
        }

        $(document).ready(onLoad);
    </script>
</head>
<jsp:include page="fragments/header.jsp"/>
<center></center>
<body>
<jsp:include page="fragments/navigationbar.jsp"/>
<div id="mainContainer">
    <div id="mainRow">
        <section id="main">
            <form:form id="details" method="POST" action="/reg/registration" modelAttribute="client">
                <form:errors path="*" cssClass="errorblock" element="div"/>
                    <table align="center" border="1" width="30%" cellpadding="5">
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
                            <td><input path="password" id="password" type="password" name="password" value=""/>
                                <br><form:errors path="password" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Confirm Password</td>
                            <td><input type="password" id="confirmpass" name="confirmpass" value=""/>
                                <div id="matchpass"></div>
                            </td>
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
