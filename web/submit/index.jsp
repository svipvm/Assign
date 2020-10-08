<%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/3
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.demo.vo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.print.StreamPrintService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/admin_style.css">
  <title>Submit</title>
</head>
<body>
<div class="inform">
  <iframe name="frame-infrom" src="userInform.jsp"></iframe>
</div>
<div class="group">
  <iframe name="frame-group" src="userGroup.jsp"></iframe>
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
</body>
</html>
