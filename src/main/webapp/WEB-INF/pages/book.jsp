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
    <title>Title</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");%>
<a href="/login">添加书籍</a></br>
<a href="">上传书籍文件</a>
<table border="1">
    <tr>
        <td>书名</td>
        <td>书籍数目</td>
        <td>操作</td>


    </tr>
    <c:forEach items="${list3}" var="map">
    <tr>

        <td>${map.B_NAME}</td>

        <td>${map.COUNT}</td>
        <td>
            <a href="/bookbase?name=${map.B_NAME}">查找</a>
            <a href="/update?id=${map.C_ID}">修改</a>
            <a href="/deleteuser?id=${map.C_ID}">删除</a>


        </td>
    </tr>
</c:forEach>

</table>
<script>

</script>
</body>
</html>


</body>
</html>
