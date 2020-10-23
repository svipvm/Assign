<%@ page import="com.demo.vo.Task" %>
<%@ page import="com.demo.vo.Admin" %><%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/20
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/struct_style.css">
  <link type="text/css" rel="stylesheet" href="../css/model_style.css">
  <title>Title</title>
</head>
<body>
  <%Admin admin = (Admin) session.getAttribute("admin");%>
  <div id="admin-return"><a href="index.jsp">返回首页</a></div>
  <div id="add-group">
    <h2>添加分组 - 管理员：<%=admin.getName()%></h2>
    <hr>
    <form action="AdminAddGroupServlet" method="post">
      <table>
        <tr>
          <td>小组ID：</td>
          <td><input type="text" name="groupID"></td>
        </tr>
        <tr>
          <td>小组名称：</td>
          <td><input type="text" name="groupName"></td>
        </tr>
        <tr>
          <td>邀请码：</td>
          <td><input type="text" name="groupCode"></td>
        </tr>
        <tr>
          <td colspan="2">
            <button type="submit">添加</button>
          </td>
        </tr>
      </table>
    </form>
    <%
      String message = new String("");
      if(request.getAttribute("message") == null) {
          message = "ID+名称为创建小组，ID+邀请码为加入小组。";
      } else {
          message = (String) request.getAttribute("message");
      }
    %>
    <div id="add-group-message"><%=message%></div>
  </div>
</body>
</html>
