<%@ page import="org.example.onlinestoreservice.beans.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>New repository</title>
</head>
<body>
<h2>
    <%
        User user = (User)request.getAttribute("user");
        out.println("<p>" + user.getName() + "</p>");
    %>
</h2>
<form action="main" method="post">
    <input type="hidden" name="command" value="new_command" />
    <input type="text" name="repository_name" id="repository_name">
    <input type="submit" value="Create">
</form>
</body>
</html>