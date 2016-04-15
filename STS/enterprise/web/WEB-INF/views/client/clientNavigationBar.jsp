<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <li><a href=<c:url value='/client/account'/>>ЛИЧНЫЙ КАБИНЕТ</a></li>
        <li><a href=<c:url value='/client/chat'/>>ЧАТ</a></li>
        <li><a href=<c:url value='/client/structure'/>>СТРУКТУРА</a></li>
        <li><a href=<c:url value='/client/news'/>>НОВОСТИ И СТАТЬИ</a></li>
        <li><a href=<c:url value='/client/order'/>>ЗАКАЗАТЬ ПРОЕКТ</a></li>
        <li><a href=<c:url value='/client/contacts'/>>КОНТАКТЫ</a></li>
        <li><a href=<c:url value='/index'/>>НА ГЛАВНУЮ</a></li>
        <sec:authorize access="hasRole('ROLE_CUSTOMER')">
            <li><a href="<c:url value="/client/tracking"/>">PROJECT TRACKING</a></li>
        </sec:authorize>
    </ul>
</nav>