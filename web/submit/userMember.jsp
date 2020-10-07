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
  <p align="center">小组成员</p>
  <hr color="#158ae7">
<%--  <div class="member-list">--%>
    <table class="member-table">
      <%for(User user : users) {%>
      <tr>
        <%
          char[] chars = user.getAccount().toCharArray();
          int sum = 0, p = 233;
          for (char aChar : chars) {
            sum = (sum * 3 + (int) aChar) % p;
          }
          String path = String.format("../img/head/bot-%s.png", sum % 18 + 1);
        %>
        <td class="member-img"><img src="<%=path%>"></td>
        <td class="member-ID"><%=user.getAccount()%></td>
        <td class="member-name"><%=user.getName()%></td>
      </tr>
      <%}%>
    </table>
<%--  </div>--%>
</body>
</html>
