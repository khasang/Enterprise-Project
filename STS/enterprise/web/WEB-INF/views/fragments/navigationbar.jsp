<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="top">
    <spring:url value="resources/images/headerLogo.png" var="logo"/>
    <spring:url value="resources/images/headerSlogan.png" var="slogan"/>
    <img id="headerLogo"
         src="${logo}" alt="Enterprise header logo image">
    <img id="headerSlogan"
         src="${slogan}" alt="slogan">
</header>

<nav id="privateArea">
    <ul>
        <li><a href=<c:url value='/registration'/>>РЕГИСТРАЦИЯ</a></li>
        <li><a href=<c:url value='/login'/>>ЛИЧНЫЙ КАБИНЕТ</a></li>
    </ul>
</nav>

<nav id="publicArea">
    <ul>
        <li><a href=<c:url value='/index'/>>ГЛАВНАЯ</a></li>
        <li><a href=<c:url value='/structure'/>>СТРУКТУРА</a></li>
        <li><a href=<c:url value='/services'/>>УСЛУГИ</a></li>
        <li><a href=<c:url value='/news'/>>НОВОСТИ И СТАТЬИ</a></li>
        <li><a href=<c:url value='/services'/>>ЗАКАЗАТЬ ПРОЕКТ</a></li>
        <li><a href=<c:url value='/contacts'/>>КОНТАКТЫ</a></li>
    </ul>
</nav>