<%@ page import="java.util.ArrayList" %>
<%@ page import="com.demo.vo.Task" %><%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/6
  Time: 17:07
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
  <jsp:include page="/submit/UserTaskServlet"/>
  <%ArrayList<Task> tasks = (ArrayList<Task>) session.getAttribute("user-tasks");%>
  <%for(Task task : tasks) {%>
  <table class="task-table">
    <tr>
      <td class="task-elem-img" rowspan="3">
        <%String colorState = (task.getEnd_time() != null ? "#E6A23C" : "#67C23A");%>
        <div class="task-state-point" style="background-color:<%=colorState%>"></div>
      </td>
      <td class="task-elem-top" colspan="2"><%= task.getTopic()%></td>
<%--      <td class="task-elem-button" rowspan="3"><button type="button">删除</button></td>--%>
    </tr>
    <tr class="task-elem-inform">
      <td>开始时间：<%=task.getStart_time()%></td>
      <td rowspan="2" class="task-elem-button">
        <a href="userContent.jsp?taskID=<%=task.getID()%>" target="frame-content">
          <button type="button">选择</button>
        </a>
      </td>
    </tr>
    <tr class="task-elem-inform">
      <td>结束时间：<%=task.getEnd_time()%></td>
    </tr>
  </table>
  <%}%>
</body>
</html>
