<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 3/15/23
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <form action="/register" method="POST">
        <div class="form-group">
            <label for="username" class="col-sm-2 col-form-label">Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <input id="email" name="email" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 col-form-label">Password</label>

            <input id="password" name="password" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="Register">
    </form>
</div>
</body>
</html>
