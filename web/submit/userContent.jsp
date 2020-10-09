<%@ page import="com.demo.vo.Task" %>
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
  <script type="text/javascript">
    function handleFils(files) {

      for(var i = 0; i < files.length; i++) {
          let file = files[0];
          let reader = new FileReader();
          reader.onload = function (e) {
              // document.getElementById("content-files").innerText = this.result;
              // alert(e.target.result);
              console.log(e);
              // alert(e.target.result);
          };
          reader.readAsText(file, "gb2312");
      }
    }
  </script>
</head>
<body>
  <jsp:include page="/submit/UserContentServlet"/>
  <%Task task = (Task) session.getAttribute("user-task");%>
  <%String taskName = (String) session.getAttribute("user-task-name");%>
  <div class="content-title"><%=task.getTopic()%></div>
  <hr color="dodgerblue">
  <div class="content-inform-user">
    <p><%=task.getContent()%> Hello World Hello World Hello World Hello World Hello World Hello World</p>
    <p>发布者：<%=taskName%></p>
    <p>开始时间：<%=task.getStart_time()%></p>
    <p>结束时间：<%=task.getEnd_time()%></p>
  </div>
  <form action="UserUploadServlet" enctype="multipart/form-data" method="post">
    <input type="file" id="uploadFile" name="uploadFile" multiple="multiple" onchange="handleFils(this.files)"/>
    <button id="content-button" type="submit">上传</button>
  </form>
  <div id="content-files"></div>
  <div id="content-message">${message}</div>
</body>
</html>
