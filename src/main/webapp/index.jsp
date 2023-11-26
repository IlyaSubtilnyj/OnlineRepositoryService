<%@ page import="org.example.onlinestoreservice.beans.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<h1>

</h1>
<c:url var="myURL" value="login">
    <c:param name="tab" value="{$}"/>
</c:url>
<a href="${myURL}">Tabs</a>
<form action="main" method="post">
    <input type="hidden" name="command" value="logging_command" />
    <input type="hidden" name="redirect" value="1" />
    <input type="text" name="username" id="username">
    <input type="password" name="password" id="password">
    <input type="submit" value="Login">
</form>
    </body>
</html>