<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 3/8/23
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <title>Login Page</title>
</head>
<%
    String errorMessage = (String) session.getAttribute("errorMessage");
    if (null !=errorMessage) { %>
<h4> <%=errorMessage %></h4>
<%}
%>
<body>
<form action="LoginServlet"  method="post" >
    Please enter your username <input type="text" name="uname" id="uname" />
    <br>
    Please enter your password <input type="text" name="pword" id="pword" />
    <input type="submit" value="submit">
</form>
</body>
</html>
