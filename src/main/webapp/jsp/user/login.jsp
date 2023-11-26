<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Log-in/sign-in</title>
    <style>
        body {
            background-color: #f2f2f2;
        }
        form {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0px 0px 10px #888888;
            padding: 20px;
            width: 300px;
            margin: 0 auto;
            margin-top: 50px;
        }
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background-color: #45a049;
        }
        .container {
            padding: 16px;
        }
        span.psw {
            float: right;
            padding-top: 16px;
        }
        @media screen and (max-width: 600px) {
            form {
                width: 80%;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <form action="main<%if (request.getParameter("redirectTo") != null) out.print("?redirectTo=" + request.getParameter("redirectTo"));%>" method="post">
        <input type="hidden" name="command" value="logging_command" />

        <label for="username"><b>Username</b></label>
        <input type="text" name="username" id="username" required>

        <label for="password"><b>Password</b></label>
        <input type="password" name="password" id="password" required>

        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>