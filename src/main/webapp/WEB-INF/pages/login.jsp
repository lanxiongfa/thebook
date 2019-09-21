<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: JSJSYS
  Date: 2019/6/28
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<title>登录页面</title>

<body>
<form action="/tologin" id="login" method="post">
    <from:errors path="*"></from:errors>
    <input type="text" name="username"><br>
    <input type="text" name="password"><br>
    <input type="submit" value="登录"><br>
    <a href="/zhuche">注册</a>
    <a href="/testExceptionResolver?i=10">cuowu</a>
</form>

</form>
</body>
</html>
