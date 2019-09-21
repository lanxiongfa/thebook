<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2019/7/30
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="/toregister" id="register" method="post">
    用户名:<input type="text" name="username"></br>
    密码:<input type="text" name="password"></br>
    年龄：<input type="text" name="age"></br>
    邮箱：<input type="text" name="email"></br>
    姓名:<input type="text" name="name"></br>
    性别；<select name="gender">
        <option value="1">男</option>
        <option value="0">女</option>
    </select></br>

    </br><input type="submit" value="注册">

</form>
</body>
</html>
