<%@ page import="com.demo.vo.Admin" %>
<%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/3
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/admin_style.css">
  <title>Task</title>
</head>
<body>
<div class="inform">
  <iframe name="frame-infrom" src="adminInform.jsp"></iframe>
</div>
<div class="group">
  <iframe name="frame-group" src="adminGroup.jsp"></iframe>
</div>
<div class="task">
  <iframe name="frame-task" src=""></iframe>
</div>
<div class="content">
  <iframe name="frame-content" src=""></iframe>
</div>
<div class="member">
  <iframe name="frame-member" src=""></iframe>
<%--  <div class="inform">--%>
<%--    <img id="head-img" src="../img/head/bot-1.png" alt="head-img">--%>
<%--    <table id="inform-table">--%>
<%--      <tr><td>ID:</td><td>Hello</td></tr>--%>
<%--      <tr><td>姓名:</td><td>Hello</td></tr>--%>
<%--      <tr><td>性别:</td><td>Hello</td></tr>--%>
<%--    </table>--%>
<%--    <div class="inform-state">--%>
<%--      <span>Hello World</span>--%>
<%--      <button class="inform-button" type="button">刷新</button>--%>
<%--    </div>--%>
<%--    <div class="inform-state">--%>
<%--      <span>Hello World</span>--%>
<%--      <button class="inform-button" type="button">注销</button>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--  <div class="group">--%>
<%--    <button type="button">创建小组</button>--%>
<%--    <div class="group-list">--%>
<%--      <% for(int i = 0; i < 10; i++) {%>--%>
<%--      <table class="group-table">--%>
<%--        <tr>--%>
<%--          <td class="group-td-left">Hello World</td>--%>
<%--          <td class="group-td-right"><button type="button">重命名</button></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <td class="group-td-left">Hello World</td>--%>
<%--          <td class="group-td-right"><button type="button">删除</button></td>--%>
<%--        </tr>--%>
<%--      </table>--%>
<%--      <%}%>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--  <div class="task">--%>
<%--    <table class="task-table">--%>
<%--      <tr>--%>
<%--        <td class="task-elem-img" rowspan="3">--%>
<%--          <div class="task-state-point" style="background-color:#67C23A"></div>--%>
<%--        </td>--%>
<%--        <td class="task-elem-top" colspan="2">Hello World</td>--%>
<%--        <td class="task-elem-button" rowspan="3"><button type="button">删除</button></td>--%>
<%--      </tr>--%>
<%--      <tr class="task-elem-inform">--%>
<%--        <td>Hello World</td>--%>
<%--        <td>Hello World</td>--%>
<%--      </tr>--%>
<%--      <tr class="task-elem-inform">--%>
<%--        <td>Hello World</td>--%>
<%--        <td>Hello World</td>--%>
<%--      </tr>--%>
<%--    </table>--%>
<%--    <%for(int i = 0; i < 10; i++) {%>--%>
<%--    <table class="task-table">--%>
<%--      <tr>--%>
<%--        <td class="task-elem-img" rowspan="3">--%>
<%--          <div class="task-state-point" style="background-color:#E6A23C"></div>--%>
<%--        </td>--%>
<%--        <td class="task-elem-top" colspan="2">Hello World</td>--%>
<%--        <td class="task-elem-button" rowspan="3"><button type="button">删除</button></td>--%>
<%--      </tr>--%>
<%--      <tr class="task-elem-inform">--%>
<%--        <td>Hello World</td>--%>
<%--        <td>Hello World</td>--%>
<%--      </tr>--%>
<%--      <tr class="task-elem-inform">--%>
<%--        <td>Hello World</td>--%>
<%--        <td>Hello World</td>--%>
<%--      </tr>--%>
<%--    </table>--%>
<%--    <%}%>--%>
<%--  </div>--%>
<%--  <div class="content">--%>
<%--    <div class="content-title">Hello World</div>--%>
<%--    <hr color="dodgerblue">--%>
<%--    <div class="content-inform">Hello World</div>--%>
<%--    <table class="content-table">--%>
<%--      <tr>--%>
<%--        <td>文件格式：</td>--%>
<%--        <td>--%>
<%--          <label>--%>
<%--            <select>--%>
<%--              <option value="I-N">ID 姓名</option>--%>
<%--              <option value="N-I">姓名 ID</option>--%>
<%--            </select>--%>
<%--          </label>--%>
<%--        </td>--%>
<%--        <td class="content-bottom"  rowspan="4"><button type="submit">收取</button></td>--%>
<%--      </tr>--%>
<%--      <tr>--%>
<%--        <td>应交人数：</td>--%>
<%--        <td>2020</td>--%>
<%--      </tr>--%>
<%--      <tr>--%>
<%--        <td>实交人数：</td>--%>
<%--        <td>2018</td>--%>
<%--      </tr>--%>
<%--      <tr>--%>
<%--        <td>文件大小：</td>--%>
<%--        <td>1024 MB</td>--%>
<%--      </tr>--%>
<%--    </table>--%>
<%--  </div>--%>
<%--  <div class="member">--%>
<%--    <p align="center">提交形况</p>--%>
<%--    <hr color="#158ae7">--%>
<%--    <div class="member-list">--%>
<%--      <table class="member-table">--%>
<%--        <%for(int i = 0; i < 40; i++) {%>--%>
<%--        <tr>--%>
<%--          <td class="member-img"><img src="../img/head/bot-2.png"></td>--%>
<%--          <td class="member-ID">123456790123</td>--%>
<%--          <td class="member-name">Hello</td>--%>
<%--          <td class="member-state">--%>
<%--            <%if(i % 2 == 0) {%>--%>
<%--              <div class="member-state-point" style="background-color:#67C23A"></div>--%>
<%--            <%} else {%>--%>
<%--              <div class="member-state-point" style="background-color:#ff0000"></div>--%>
<%--            <%}%>--%>
<%--          </td>--%>
<%--        </tr>--%>
<%--        <%}%>--%>
<%--      </table>--%>
<%--    </div>--%>
<%--  </div>--%>
</body>
</html>
