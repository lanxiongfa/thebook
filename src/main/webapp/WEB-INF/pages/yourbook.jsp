<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2019/7/31
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍页面</title>
</head>
<body>

    <h1>书名:${showbook.B_NAME}</h1></br>
    <h1>作者:${showbook.B_AUTHOR}</h1></br>
    <h1>出版社:${showbook.B_PUB}</h1></br>
    <h1>出版日期:${showbook.B_DATA}</h1></br>




<h1>书籍库存:  ${other} / ${count}</h1></br>

</br>
</br>


<table border="1">
    <tr>
        <td>书号</td>
        <td>书名</td>
        <td>是否借阅</td>
        <td>借书人编号</td>


    </tr>
    <c:forEach items="${list}" var="map">
        <tr>

            <td>${map.B_ID}</td>
            <td>${map.B_NAME}</td>
            <td><c:if test="${'1'eq map.B_STA}"> 以借阅 </c:if>
                <c:if test="${'0'eq map.B_STA}"> 未借阅 </c:if>

            </td>
            <td><c:if test="${'1'eq map.B_STA}"> ${map.C_ID} </c:if>
                <c:if test="${'0'eq map.B_STA}"> 无 </c:if></td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
