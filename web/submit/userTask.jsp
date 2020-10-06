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
  <%ArrayList<Task> taskList = (ArrayList<Task>) request.getAttribute("user-task");%>
  <table class="task-table">
    <tr>
      <td class="task-elem-img" rowspan="3">
        <div class="task-state-point" style="background-color:#67C23A"></div>
      </td>
      <td class="task-elem-top" colspan="2">Hello World</td>
      <%--      <td class="task-elem-button" rowspan="3"><button type="button">删除</button></td>--%>
    </tr>
    <tr class="task-elem-inform">
      <td>Hello World</td>
      <td>Hello World</td>
    </tr>
    <tr class="task-elem-inform">
      <td>Hello World</td>
      <td>Hello World</td>
    </tr>
  </table>
  <%for(int i = 0; i < 10; i++) {%>
  <table class="task-table">
    <tr>
      <td class="task-elem-img" rowspan="3">
        <div class="task-state-point" style="background-color:#E6A23C"></div>
      </td>
      <td class="task-elem-top" colspan="2">Hello World</td>
      <%--      <td class="task-elem-button" rowspan="3"><button type="button">删除</button></td>--%>
    </tr>
    <tr class="task-elem-inform">
      <td>Hello World</td>
      <td>Hello World</td>
    </tr>
    <tr class="task-elem-inform">
      <td>Hello World</td>
      <td>Hello World</td>
    </tr>
  </table>
  <%}%>
</body>
</html>
