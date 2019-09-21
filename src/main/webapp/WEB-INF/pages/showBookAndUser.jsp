<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2019/8/2
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍及借阅者信息</title>
</head>
<body>
<table border="1">
    <tr>
        <td>书号</td>
        <td>书名</td>
        <td>借阅者</td>
        <td>借书人编号</td>


    </tr>

    <tr>

        <td>${showall.B_ID}</td>
        <td><a href="/findbook?name=${showall.B_NAME}">${showall.B_NAME}</a></td>
        <td>${showall.C_ID}</td>
        <td>${showall.C_NAME}</td>




    </tr>


</body>
</html>
