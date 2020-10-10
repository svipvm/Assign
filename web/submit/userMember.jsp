<%@ page import="java.util.ArrayList" %>
<%@ page import="com.demo.vo.User" %><%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/7
  Time: 16:12
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
  <jsp:include page="/submit/UserMemberServlet"/>
  <%ArrayList<User> users = (ArrayList<User>) session.getAttribute("user-member");%>
  <%ArrayList<String> imgPath = (ArrayList<String>) session.getAttribute("user-member-img");%>
  <p align="center">小组成员</p>
  <hr color="#158ae7">
<%--  <div class="member-list">--%>
    <table class="member-table">
      <%for(int i = 0; i < users.size(); i++) {%>
      <tr>
        <td class="member-img"><img src="<%=imgPath.get(i)%>"></td>
        <td class="member-ID"><%=users.get(i).getAccount()%></td>
        <td class="member-name"><%=users.get(i).getName()%></td>
      </tr>
      <%}%>
    </table>
<%--  </div>--%>
</body>
</html>
