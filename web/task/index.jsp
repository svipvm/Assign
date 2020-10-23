<%@ page import="com.demo.vo.Admin" %>
<%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/3
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/struct_style.css">
  <title>Task</title>
</head>
<body>
<div id="limit-box">
  <div class="inform">
    <iframe name="frame-infrom" src="adminInform.jsp"></iframe>
  </div>
  <div class="group">
    <iframe name="frame-group" src="adminGroup.jsp"></iframe>
  </div>
  <div class="task">
    <iframe name="frame-task" src=""></iframe>
  </div>
  <div class="content">
    <iframe name="frame-content" src=""></iframe>
  </div>
  <div class="member">
    <iframe name="frame-member" src=""></iframe>
  </div>
</div>
</body>
</html>
