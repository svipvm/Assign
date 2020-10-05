<%@ page import="com.demo.vo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.print.StreamPrintService" %><%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/3
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/admin_style.css">
  <title>Submit</title>
</head>
<body>
<jsp:include page="/submit/LoadingUserServlet"/>
<div class="inform">
  <%ArrayList<String> inform = (ArrayList<String>) session.getAttribute("user-inform");%>
  <img id="head-img" src="<%=inform.get(3)%>" alt="head-img">
  <table id="inform-table">
    <tr><td>ID:</td><td><%=inform.get(0)%></td></tr>
    <tr><td>姓名:</td><td><%=inform.get(1)%></td></tr>
    <tr><td>性别:</td><td><%=inform.get(2)%></td></tr>
  </table>
  <div class="inform-state">
    <span><%=inform.get(4)%></span>
    <button class="inform-button" type="button">刷新</button>
  </div>
  <div class="inform-state">
    <span><%=inform.get(5)%></span>
    <button class="inform-button" type="button">注销</button>
  </div>
</div>
<div class="group">
  <button type="button">加入小组</button>
  <div class="group-list">
    <% for(int i = 0; i < 10; i++) {%>
    <table class="group-table">
      <tr>
        <td class="group-td-left">Hello World</td>
<%--        <td class="group-td-right"><button type="button">重命名</button></td>--%>
      </tr>
      <tr>
        <td class="group-td-left">Hello World</td>
<%--        <td class="group-td-right"><button type="button">删除</button></td>--%>
      </tr>
    </table>
    <%}%>
  </div>
</div>
<div class="task">
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
</div>
<div class="content">
  <div class="content-title">Hello World</div>
  <hr color="dodgerblue">
  <div class="content-inform-user">Hello World</div>
  <form action="#" enctype="multipart/form-data" method="post">
    <input type="file" name="uploadFile" />
    <br/><br/>
    <button type="submit">上传</button>
  </form>

</div>
<div class="member">
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
</div>
</body>
</html>
