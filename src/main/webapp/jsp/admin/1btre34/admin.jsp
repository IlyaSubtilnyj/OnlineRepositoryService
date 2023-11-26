<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.example.onlinestoreservice.beans.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<h1>
    Admin form
</h1>
<form action="main<%if (request.getParameter("redirectTo") != null) out.print("?redirectTo=" + request.getParameter("redirectTo"));%>" method="post">
    <input type="hidden" name="command" value="admin_logging_command" />
    <input type="text" name="username" id="username">
    <input type="password" name="password" id="password">
    <input type="submit" value="admin_login">
</form>
</body>
</html>