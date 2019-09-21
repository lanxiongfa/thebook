<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JSJSYS
  Date: 2019/7/3
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找书籍</title>
</head>
<body>
<a href="/login">登录</a>
    <table border="1">
        <tr>

            <td>书名</td>
            <td>操作</td>


        </tr>
        <c:forEach items="${list1}" var="map">
        <tr>

            <td>${map.B_NAME}</td>

            <td>
                <a href="/findbook?name=${map.B_NAME}">查看</a><br>


            </td>
        </tr>
        </c:forEach>

    </table>

</body>
</html>
