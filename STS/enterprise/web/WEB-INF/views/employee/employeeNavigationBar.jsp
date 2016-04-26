<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<header class="top">
    <spring:url value="/resources/images/headerLogo.png" var="clogo"/>
    <spring:url value="/resources/images/headerSlogan.png" var="cslogan"/>
    <img id="headerLogo"
         src="${clogo}" alt="Enterprise header logo image">
    <img id="headerSlogan"
         src="${cslogan}" alt="slogan">
</header>

<nav id="privateArea">
    <ul>
        <c:url value="/logout" var="logoutURL"/>
        <li><a href="${logoutURL}">ВЫХОД</a></li>
    </ul>
</nav>

<nav id="publicArea">
    <ul>
        <li><a href=<c:url value='/employee/account'/>>ЛИЧНЫЙ КАБИНЕТ</a></li>
        <li><a href=<c:url value='/employee/all-projects'/>>ВСЕ ПРОЕКТЫ</a></li>
        <li><a href=<c:url value='/employee/tracking'/>>TRACKING</a></li>
        <li><a href=<c:url value='/employee/mytasks'/>>MY TASKS</a></li>
        <li><a href=<c:url value='/employee/myaccount'/>>MY ACCOUNT</a></li>

    </ul>
</nav>