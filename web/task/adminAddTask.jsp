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
  <div id="admin-add-task">
    <h2>添加任务 - 组长：<%=admin.getName()%></h2>
    <hr>
    <form action="AdminAddTaskServlet" method="post">
      <table id="admin-add-task-table">
        <tr>
          <td>主题：</td>
          <td><input type="text" name="topic"></td>
        </tr>
        <tr>
          <td>内容：</td>
          <td><input type="text" name="content"></td>
        </tr>
        <tr>
          <td colspan="2"><button type="submit">添加</button></td>
        </tr>
      </table>
    </form>
    <%
      String message = (String) request.getAttribute("message");
      if(message == null) {
          message = new String("请输入任务的主题与内容！");
      }
    %>
    <div id="admin-add-task-message"><%=message%></div>
  </div>
</body>
</html>
