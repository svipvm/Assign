<%@ page import="com.demo.vo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.print.StreamPrintService" %><%--
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
  <iframe name="frame-task" src="userTask.jsp"></iframe>
</div>
<div class="content">
  <div class="content-title">Hello World</div>
  <hr color="dodgerblue">
  <div class="content-inform-user">Hello World</div>
  <form action="#" enctype="multipart/form-data" method="post">
    <input type="file" name="uploadFile" />
    <br/><br/>
    <button type="submit">上传</button>
  </form>

</div>
<div class="member">
  <p align="center">小组成员</p>
  <hr color="#158ae7">
  <div class="member-list">
    <table class="member-table">
      <%for(int i = 0; i < 40; i++) {%>
      <tr>
        <td class="member-img"><img src="../img/head/bot-2.png"></td>
        <td class="member-ID">123456790123</td>
        <td class="member-name">Hello</td>
      </tr>
      <%}%>
    </table>
  </div>
</div>
</body>
</html>
