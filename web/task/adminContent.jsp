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
  <script type="text/javascript">
      window.onload=function (){
          var memberFrame = parent.document.getElementsByName('frame-member')[0];
          memberFrame.src = "adminMember.jsp";
      }
  </script>
  <title>Title</title>
</head>
<body>
  <jsp:include page="/task/AdminContentServlet"/>
  <%Task task = (Task) session.getAttribute("admin-task");%>
<%--  <%String taskName = (String) session.getAttribute("admin-task-name");%>--%>
<%--  <%ArrayList<String> fileName = (ArrayList<String>) request.getAttribute("admin-fileName");%>--%>
  <div class="content-title"><%=task.getTopic()%></div>
  <hr color="dodgerblue">
  <div class="content-inform-user">
    <p><%=task.getContent()%></p>
<%--    发布者：<%=taskName%><br>--%>
    开始时间：<%=task.getStart_time()%><br>
    结束时间：<%=task.getEnd_time()%>
  </div>
  <div id="content-task-message">${message}</div>
  <table id="table-files">
    <tr>
      <td>应交人数：</td>
      <td><%=session.getAttribute("admin-sum")%></td>
    </tr>
    <tr>
      <td>实交人数：</td>
      <td><%=session.getAttribute("admin-count")%></td>
    </tr>
    <tr>
      <td>收取次数：</td>
      <td><%=session.getAttribute("admin-down")%></td>
    </tr>
    <tr>
      <td><button onclick="adminContentRefresh(<%=task.getID()%>)">刷新</button></td>
      <td><button onclick="adminTaskHalt()">结束</button></td>
    </tr>
    <tr>
<%--      <td><button onclick="adminDelTask()">删除</button></td>--%>
      <td colspan="2"><button onclick="adminAcceptFile()">收集任务</button></td>
    </tr>
  </table>
<%--  <form action="UserUploadServlet" enctype="multipart/form-data" method="post">--%>
<%--    <input type="file" id="uploadFile" name="uploadFile" multiple="multiple"/>--%>
<%--    <button id="content-button" type="submit">上传</button>--%>
<%--  </form>--%>
<%--  <div id="content-message">${message}</div>--%>
</body>
</html>
