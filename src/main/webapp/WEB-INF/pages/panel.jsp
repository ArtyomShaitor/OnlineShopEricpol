<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 28.11.2014
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=CP1251" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Panel</title>
</head>
<body>
    Hello, Admin!
    <br/>
    <a href="/logout">�����</a>
    <br>
    <br/>
    <a href="<c:url value="/Admin/Panel/Add" />">��������</a>
    <br/>
    <br/>
    ������ �������:
    <table>
        <tr>
            <td>id</td>
            <td>��������</td>
            <td>�����</td>
        </tr>
    <c:forEach items="${itemList}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.title}</td>
            <td>
                <a href="<c:url value="/Admin/Panel/Edit/${item.id}" />">��������</a>
                <a href="<c:url value="/Admin/Panel/Delete/${item.id}" />">�������</a>
            </td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
