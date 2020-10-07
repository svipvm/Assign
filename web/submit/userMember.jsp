<%--
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
</body>
</html>
