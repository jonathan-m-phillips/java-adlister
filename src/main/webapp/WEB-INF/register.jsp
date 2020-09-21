<%--
  Created by IntelliJ IDEA.
  User: jonathanphillips
  Date: 9/21/20
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/WEB-INF/login.jspogin.jsp" method="POST">
    <div class="form-group">
        <label for="username">Username</label>
        <input id="username" name="username" class="form-control" type="text">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input id="password" name="password" class="form-control" type="password">
    </div>
    <label for="email">Email</label>
    <input id="email" name="email" class="form-control" type="text">
    </div>
    <div class="form-group">
        <label for="firstName">First Name</label>
        <input id="firstName" name="firstName" class="form-control">
    </div>
    <div class="form-group">
        <label for="lastName">First Name</label>
        <input id="lastName" name="lastName" class="form-control">
    </div>

    <input type="submit" class="btn btn-primary btn-block" value="Register">
</form>
</body>
</html>
