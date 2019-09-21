<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2019/7/29
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
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
    <title>用户列表</title>
</head>
<body>
<a href="/login">登录</a>
<table border="1">
    <tr>
        <td>用户id</td>
        <td>用户姓名</td>
        <td>账户名</td>
        <td>年龄</td>
        <td>性别</td>


        <td>操作</td>


    </tr>
    <c:forEach items="${list2}" var="map">
        <tr>
            <td>${map.C_ID}</td>
            <td>${map.C_NAME}</td>
            <td> ${map.C_USERNAME}</td>
            <td>${map.C_AGE}</td>
            <td><c:if test="${'1'==map.GENDER}"> 男 </c:if>
                <c:if test="${'0'==map.GENDER}"> 女 </c:if>
            </td>


            <td>
                <a href="/findbook?id=${map.C_ID}">查找</a><br>
                <a href="/toupdate?id=${map.C_ID}">修改</a><br>
                <a href="/deleteuser?id=${map.C_ID}">删除</a><br>
                <a href="/loginLogging?username=${map.C_USERNAME}">日志</a>

            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>


</body>
</html>
