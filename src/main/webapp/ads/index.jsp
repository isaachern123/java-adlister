<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 3/10/23
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ad List</title>
</head>
<body>

    <h1>ADVERTISEMENTS</h1>
        <ul>
            <c:forEach var="ad" items="${ads}">
                <li>Title: ${ad.title} <br> Description: ${ad.description}</li>
                <br>
            </c:forEach>

        </ul>
</body>
</html>
