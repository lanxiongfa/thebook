<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JSJSYS
  Date: 2019/7/4
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新用户</title>
</head>
<body>
<form action="/userupdate" method="post">
    用户编号    <input type="text"name="id" value="${map.C_ID}" readonly="readonly" ></br>

    用户名:<input type="text"name="name" value="${map.C_NAME}" ></br>

    用户邮箱:<input type="text"name="email" value="${map.C_EMAIL}" ></br>

    用户年龄:<input type="text"name="age" value="${map.C_AGE}" ></br>
    用户性别:<select name="gender" >
    <option value="1" <c:if test="${'1'eq map.GENDER}">selected</c:if>>男</option>
    <option value="0" <c:if test="${'0'eq map.GENDER}">selected</c:if>>女</option>

    </select></br>

    登录名:<input type="text"name="username" value="${map.C_USERNAME}"></br>

    登录密码:<input type="text"name="password" value="${map.C_PASSWORD}"></br>


   <input type="submit" value="更新"> </br>

</form>


</body>
</html>
