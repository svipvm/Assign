<%@ page import="com.demo.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/3
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Title</title>
</head>
<body>
  <% User user = (User) session.getAttribute("user"); %>
  <%= user.getAccount() %> Submit, Hello World.
</body>
</html>
