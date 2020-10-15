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
  <link type="text/css" rel="stylesheet" href="../css/struct_style.css">
  <link type="text/css" rel="stylesheet" href="../css/model_style.css">
  <script type="text/javascript" src="../js/modify.js"></script>
  <title>Title</title>
</head>
<body>
  <%User user = (User) session.getAttribute("user");%>
  <div class="modify-box">
    <h2>用户：<%=user.getName()%></h2>
    <hr color="dodgerblue">
    <ul>
      <li>密码长度为 6~20 位，不允许特殊字符</li>
      <li>密码更改成功后将自动返回登录界面</li>
    </ul>
    <form action="UserModifyServlet" method="post" onsubmit="return checkModify()">
      <table class="modify-table">
        <tr>
          <td class="left-td">当前密码：</td>
          <td><input class="pw-text" type="password" name="old_password" id="old_password"></td>
        </tr>
        <tr>
          <td class="left-td">新的密码：</td>
          <td><input class="pw-text" type="password" name="new_password" id="new_password"></td>
        </tr>
        <tr>
          <td class="left-td">确认密码：</td>
          <td><input class="pw-text" type="password" name="re_password" id="re_password"></td>
        </tr>
        <tr><td colspan="2"><button type="submit">更改密码</button></td></tr>
      </table>
    </form>
    <div id="modify-message">${message}</div>
  </div>
</body>
</html>
