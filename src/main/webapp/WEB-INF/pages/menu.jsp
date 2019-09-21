<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2019/7/29
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单</title>
</head>
<body>
<a href="/book"><button>查找书籍</button></a> </br>
<a href="/user?username=${username}"><button>用户管理</button></a> </br>
<a href="/showbook?username=${username}"><button>图书管理</button></a> </br>

</body>
</html>
