<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/27
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testing parameters recieve</title>
</head>
<body>

<h1>
    testing
</h1>
<form action="${pageContext.request.contextPath}/param/test" method="get">
    userID:<input type="text" name="id">
    <input type="submit" value="submit"/>
</form>
</body>
</html>
