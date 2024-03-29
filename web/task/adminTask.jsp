<%@ page import="com.demo.vo.Task" %>
<%@ page import="java.util.ArrayList" %>
<%--
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
  <script type="text/javascript" src="../js/request.js"></script>
  <title>Title</title>
</head>
<body>
  <jsp:include page="/task/AdminTaskServlet"/>
  <%ArrayList<Task> tasks = (ArrayList<Task>) session.getAttribute("admin-tasks");%>
  <%int len = tasks.size();%>
  <div id="task-add"><button type="button" onclick="adminAddTask()">添加任务</button></div>
  <%for(int i = len - 1; 0 <= i; i--) {%>
    <%Task task = tasks.get(i);%>
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
  <%--        <a href="adminMember.jsp?groupID=<%=request.getParameter("groupID")%>" target="frame-member">--%>
            <button type="button" onclick="reAdminMember('<%=task.getID()%>')">选择</button>
  <%--        </a>--%>
        </td>
      </tr>
      <tr class="task-elem-inform">
        <td>结束时间：<%=task.getEnd_time()%></td>
      </tr>
    </table>
  <%}%>
  <br>
</body>
</html>
