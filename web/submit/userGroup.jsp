<%@ page import="java.util.ArrayList" %>
<%@ page import="com.demo.vo.Muster" %><%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/6
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/model_style.css">
  <script type="text/javascript" src="../js/request.js"></script>
  <title>Title</title>
</head>
<body>
  <jsp:include page="/submit/UserGroupServlet"/>
  <%ArrayList<Muster> groupList = (ArrayList<Muster>) session.getAttribute("user-group");%>
  <%ArrayList<Integer> countList = (ArrayList<Integer>) session.getAttribute("user-member-count");%>
  <button id="group-button" type="button" onclick="userAddGroup()">加入小组</button>
  <%for(int i = 0; i < groupList.size(); i++) {%>
    <%Muster group = groupList.get(i);%>
    <%Integer count = countList.get(i);%>
    <table class="group-table">
      <tr>
        <td class="group-td-left"><%=group.getName()%></td>
        <td class="group-td-right">
<%--          <button type="button">选择</button>--%>
        </td>
      </tr>
      <tr>
        <td class="group-td-left">小组成员数：<%=count%></td>
        <td class="group-td-right">
          <a href="userTask.jsp?groupID=<%=group.getID()%>" target="frame-task">
            <button type="button" onclick="reMenber('<%=group.getID()%>')">选择</button>
          </a>
        </td>
      </tr>
      </table>
    <%}%>
</body>
</html>
