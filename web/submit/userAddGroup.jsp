<%@ page import="com.demo.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2020/10/23
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/model_style.css">
  <link type="text/css" rel="stylesheet" href="../css/struct_style.css">
  <script type="text/javascript" src="../js/login.js"></script>
  <title>Title</title>
</head>
<body>
  <%User user = (User) session.getAttribute("user");%>
<%--  <%=user.getName()%>--%>
  <div id="index-return"><a href="index.jsp">返回首页</a></div>
  <div id="user-add-group">
    <h1>加入小组 - 成员：<%=user.getName()%></h1>
    <hr><br>
    <form action="#" method="post" onsubmit="return userCheckCode()">
      邀请码：<input type="text" id="groupCode" name="groupCode">
      <button type="submit">加入小组</button>
    </form>
  </div>
</body>
</html>
