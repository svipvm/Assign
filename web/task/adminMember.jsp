<%@ page import="com.demo.vo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %><%--
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
  <title>Title</title>
</head>
<body>
  <jsp:include page="/task/AdminMemberServlet"/>
  <%ArrayList<User> users = (ArrayList<User>) session.getAttribute("admin-member");%>
  <%Map<String, Integer> subCount = (Map<String, Integer>) session.getAttribute("admin-status");%>
<%--  <%ArrayList<String> imgPath = (ArrayList<String>) session.getAttribute("admin-member-img");%>--%>
  <p align="center">小组成员</p>
  <hr color="#158ae7">
  <table class="member-table">
    <%for(int i = 0; i < users.size(); i++) {%>
    <tr>
      <%String account = users.get(i).getAccount();%>
      <%String point = (subCount.get(account) == 0 ? "#E6A23C" : "#67C23A");%>
      <td class="member-point">
        <div class="task-state-point" style="background-color:<%=point%>"></div>
      </td>
      <td class="member-ID"><%=users.get(i).getAccount()%></td>
      <td class="member-name"><%=users.get(i).getName()%></td>
    </tr>
    <%}%>
  </table>
</body>
</html>
