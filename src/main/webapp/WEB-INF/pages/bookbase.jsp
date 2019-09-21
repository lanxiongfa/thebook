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

<a href="/login">添加书籍</a></br>

<table border="1">
    <tr>
        <td>书号</td>
        <td>书名</td>
        <td>是否借阅</td>
        <td>借阅者</td>
        <td>操作</td>



    </tr>
    <c:forEach items="${list}" var="map">
    <tr>
        <td>${map.B_ID}</td>
        <td>${map.B_NAME}</td>
        <td><c:if test="${'1'eq map.B_STA}"> 以借阅 </c:if>
            <c:if test="${'0'eq map.B_STA}"> 未借阅 </c:if>
        </td>
        <td>
            <c:if test="${'1'eq map.B_STA}"> ${map.C_ID} </c:if>
            <c:if test="${'0'eq map.B_STA}"> 无 </c:if>
        </td>




        <td>

            <c:if test="${'1'eq map.B_STA}">  <a href="/showAll?id=${map.B_ID}">查找</a></c:if>
            <c:if test="${'0'eq map.B_STA}">  <a href="/borrow?bid=${map.B_ID}&&sta=${map.B_STA}">借阅</a> </c:if>

            <a href="/update?id=${map.B_ID}">修改</a>
            <a href="/deleteuser?id=${map.B_ID}">删除</a>


        </td>
    </tr>
</c:forEach>

</table>


<script>
    var url=encodeURI("/")
</script>


</body>
</html>
