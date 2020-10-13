<%@ page import="com.demo.vo.Task" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/7
  Time: 22:43
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
  <jsp:include page="/submit/UserContentServlet"/>
  <%Task task = (Task) session.getAttribute("user-task");%>
  <%String taskName = (String) session.getAttribute("user-task-name");%>
  <%ArrayList<String> fileName = (ArrayList<String>) request.getAttribute("user-fileName");%>
    <div class="content-title"><%=task.getTopic()%></div>
  <hr color="dodgerblue">
  <div class="content-inform-user">
    <p><%=task.getContent()%></p>
    发布者：<%=taskName%><br>
    开始时间：<%=task.getStart_time()%><br>
    结束时间：<%=task.getEnd_time()%>
  </div>
  <form action="UserUploadServlet" enctype="multipart/form-data" method="post">
    <input type="file" id="uploadFile" name="uploadFile" multiple="multiple"/>
    <button id="content-button" type="submit">上传</button>
  </form>
  <div id="content-files">
    <%if(fileName != null) {%>
      <%for(int i = 1; i <= fileName.size(); i++) {%>
        <%=i%>：<%=fileName.get(i - 1)%><br/>
      <%}%>
    <%} else if(task.getEnd_time() == null) {%>
      <p>请选择文件，并上传！</p>
    <%} else {%>
      <p>任务已结束，无法提交！</p>
    <%}%>
  </div>
  <div id="content-message">${message}</div>
</body>
</html>
