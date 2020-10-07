<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/6
  Time: 15:21
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
  <jsp:include page="/submit/UserInformServlet"/>
  <%ArrayList<String> inform = (ArrayList<String>) session.getAttribute("user-inform");%>
  <img id="head-img" src="<%=inform.get(3)%>" alt="head-img">
  <table id="inform-table">
    <tr><td>ID:</td><td><%=inform.get(0)%></td></tr>
    <tr><td>姓名:</td><td><%=inform.get(1)%></td></tr>
    <tr><td>性别:</td><td><%=inform.get(2)%></td></tr>
  </table>
  <div class="inform-state">
    <span><%=inform.get(4)%></span>
    <button class="inform-button" type="button">刷新</button>
  </div>
  <div class="inform-state">
    <span><%=inform.get(5)%></span>
    <button class="inform-button" type="button">注销</button>
  </div>
</body>
</html>