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
<form action=/register" method="POST">
    <div class="input-group mb-3">
        <input type="text" class="form-control" name="email" placeholder="Email">
    </div>
    <div class="input-group mb-3">
        <input type="text" class="form-control" name="username" placeholder="Username">
    </div>
    <div class="input-group mb-3">
        <input type="text" class="form-control" name="password" placeholder="Password">
    </div>
    <button type="submit">Register</button>
</form>
</body>
</html>
