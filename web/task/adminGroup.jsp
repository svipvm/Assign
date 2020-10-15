<%@ page import="com.demo.vo.Muster" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2020/10/13
  Time: 9:43
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
  <jsp:include page="/task/AdminGroupServlet"/>
  <%ArrayList<Muster> groupList = (ArrayList<Muster>) session.getAttribute("admin-group");%>
  <%ArrayList<Integer> countList = (ArrayList<Integer>) session.getAttribute("admin-member-count");%>
  <button id="group-button" type="button">加入小组</button>
  <%for(int i = 0; i < groupList.size(); i++) {%>
  <%Muster group = groupList.get(i);%>
  <%Integer count = countList.get(i);%>
  <table class="group-table">
    <tr>
      <td class="group-td-left"><%=group.getName()%></td>
      <td class="group-td-right">
          <button type="button">管理</button>
      </td>
    </tr>
    <tr>
      <td class="group-td-left">小组成员数：<%=count%></td>
      <td class="group-td-right">
        <a href="adminTask.jsp?groupID=<%=group.getID()%>" target="frame-task">
          <button type="button">选择</button>
        </a>
      </td>
    </tr>
  </table>
  <%}%>
</body>
</html>
