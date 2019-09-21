<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2019/8/2
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借书页面</title>
</head>
<body>
<table border="1">
    <tr>
        <td>用户id</td>
        <td>用户姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>邮箱</td>
        <td>用户名</td>
        <td>登录密码</td>
        <td>操作</td>


    </tr>
    <c:forEach items="${showuser}" var="map">
        <tr>
            <td>${map.C_ID}</td>
            <td>${map.C_NAME}</td>
            <td>${map.C_AGE}</td>
            <td><c:if test="${'1'==map.GENDER}"> 男 </c:if>
                <c:if test="${'0'==map.GENDER}"> 女 </c:if>
            </td>
            <td>${map.C_EMAIL}</td>
            <td>${map.C_USERNAME}</td>
            <td>${map.C_PASSWORD}</td>

            <td>
                <a href="/borrowbook?cid=${map.C_ID}&&bid=${bid}&&sta=${sta}">借阅</a>


            </td>
        </tr>
    </c:forEach>

</table>


</body>
</html>
