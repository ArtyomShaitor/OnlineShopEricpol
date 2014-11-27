<%--
  Created by IntelliJ IDEA.
  User: HOME
  Date: 25.11.2014
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <h1>List</h1>
    <c:forEach items="${itemList}" var="item" >
        ${item.title}
    </c:forEach>
</body>
</html>
