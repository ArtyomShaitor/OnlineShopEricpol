<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 28.11.2014
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>${Title}</title>
</head>
<body>
    <form method="post" action="<c:url value="/${action}" />" enctype="multipart/form-data" accept-charset="ISO-8859-1">
        <table>
            <tr>
                <td>Название</td>
                <td>
                    <input type="text" name="title" value="${mainItem.title}" />
                    <input type="hidden" name="ID" value="${ID}" />
                </td>
            </tr>
            <tr>
                <td>Тип</td>
                <td>
                    <select name="type_id">
                    <c:forEach items="${typeList}" var="item">
                        <c:choose>
                            <c:when test="${mainItem.type_id == 0}">
                                <option value="${item.id}">${item.title}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${item.id}" selected>${item.title}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Бренд</td>
                <td>
                    <select name="brand_id">
                        <c:forEach items="${brandList}" var="item">
                            <c:choose>
                                <c:when test="${mainItem.brand_id == item.id}">
                                    <option value="${item.id}" selected>${item.title}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${item.id}">${item.title}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Описание</td>
                <td>
                    <textarea name="description" placeholder="Описание">${mainItem.description}</textarea>
                </td>
            </tr>
            <tr>
                <td>Цена</td>
                <td><input type="text" name="price" value="${mainItem.price}" /> </td>
            </tr>
            <tr>
                <td>Изображение</td>
                <td>
                    <c:choose>
                        <c:when test="${mainItem.cover_url != null}">
                            <img src="<c:url value="/res/catalog/${mainItem.cover_url}"/>"><br/>
                            <%--<input type="hidden" name="cover_url" value="${mainItem.cover_url}">    --%>
                            <input name="cover_url" type="file">
                        </c:when>
                        <c:otherwise>
                            <input name="cover_url" type="file">
                        </c:otherwise>
                    </c:choose>
                    <br/>

                </td>
            </tr>
            <tr>
                <td><input type="submit" value="${submitValue}" /></td>
                <td></td>
            </tr>
        </table>
    </form>
</body>
</html>

<c:if test="${mainItem.cover_url != null}">

    <style>
        img {
            width:300px;
        }
    </style>

</c:if>