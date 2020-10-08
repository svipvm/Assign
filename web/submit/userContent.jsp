<%@ page import="com.demo.vo.Task" %><%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/7
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/model_style.css">
  <title>Title</title>
</head>
<body>
  <jsp:include page="/submit/UserContentServlet"/>
  <%Task task = (Task) session.getAttribute("user-task");%>
  <div class="content-title">Hello World</div>
  <hr color="dodgerblue">
  <div class="content-inform-user">Hello World</div>
  <form action="#" enctype="multipart/form-data" method="post">
    <input type="file" name="uploadFile" />
    <br/><br/>
    <button type="submit">上传</button>
  </form>
</body>
</html>
