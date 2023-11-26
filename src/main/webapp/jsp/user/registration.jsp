<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<h1>
    <%
        out.println("Hello, are you ready to surf our catalog? Let's register you!");
    %>
</h1>
<form action="main" method="post">
    <input type="hidden" name="command" value="user_register" />
    <input type="text" name="username" id="username">
    <input type="password" name="password" id="password">
    <input type="submit" value="user_register">
</form>
</body>
</html>