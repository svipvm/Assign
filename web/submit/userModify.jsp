<%@ page import="com.demo.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/10
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/admin_style.css">
  <link type="text/css" rel="stylesheet" href="../css/model_style.css">
  <title>Title</title>
</head>
<body>
  <%User user = (User) session.getAttribute("user");%>
  <div class="modify-box">
    <h2>用户：<%=user.getName()%></h2>
    <hr color="dodgerblue">
    <form action="submit/UserModifyServlet" method="post">
      <table class="modify-table">
        <tr>
          <td class="left-td">当前密码：</td>
          <td><input class="pw-text" type="password" name="old_password"></td>
        </tr>
        <tr>
          <td class="left-td">新的密码：</td>
          <td><input class="pw-text" type="password" name="new_password"></td>
        </tr>
        <tr>
          <td class="left-td">确认密码：</td>
          <td><input class="pw-text" type="password" name="re_password"></td>
        </tr>
        <tr><td colspan="2"><button type="submit">更改密码</button></td></tr>


      </table>
    </form>
  </div>
</body>
</html>
