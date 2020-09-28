<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/28
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findAll jsp</title>
</head>
<body>
    <c:forEach items="${requestScope.users}" var="user">
        ${user.id}
    </c:forEach>

</body>
</html>
