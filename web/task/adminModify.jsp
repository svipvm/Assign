<%@ page import="com.demo.vo.Admin" %>
<%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2020/10/13
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/model_style.css">
  <link type="text/css" rel="stylesheet" href="../css/struct_style.css">
  <title>Title</title>
</head>
<body>
  <%Admin admin = (Admin) session.getAttribute("admin");%>
  <div class="modify-box">
    <h2>管理员：<%=admin.getName()%></h2>
    <hr color="dodgerblue">
    <ul>
      <li>密码长度为 6~20 位，不允许特殊字符</li>
      <li>密码更改成功后将自动返回登录界面</li>
    </ul>
    <form action="AdminModifyServlet" method="post" onsubmit="return checkModify()">
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
