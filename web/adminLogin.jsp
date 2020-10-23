<%--
  Created by IntelliJ IDEA.
  User: vmice
  Date: 2020/10/1
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="css/login_style.css">
  <script type="text/javascript" src="js/login.js"></script>
  <title>任务布置 - 登录</title>
</head>
<body>
  <div class="content-box">
    <div class="content left-style">
      <h1>任务布置 Topic</h1>
      <hr size="2" color="black">
      <ul>
        <li><p>一位小组组长可以加入多个小组</p></li>
        <li><p>一个小组可以有多个小组组长</p></li>
        <li><p>一位小组组长可以在小组发布多个任务</p></li>
        <li><p>小组组长在组里只有踢出成员，发布任务的权限</p></li>
        <li><p>小组组长可以看到每个任务中每个成员的提交情况</p></li>
        <li><p>小组组长只可在结束任务后才可收取任务结果</p></li>
      </ul>
    </div>
    <div class="content right-style">
      <h1>组长登录</h1>
      <hr size="2" color="black">
      <form action="AdminLoginServlet" method="post" onsubmit="return login_check()">
        <ul>
          <li><p>Account</p></li>
          <li><input class="text-input" id="account" type="text" name="account"></li>
          <li><p>Password</p></li>
          <li><input class="text-input" id="password" type="password" name="password"></li>
          <li><p><input class="login-bt" type="submit" value="登录"></p></li>
        </ul>
      </form>
<%--      <p class="message">Hello World!</p>--%>
      <p class="message">${message} </p>
    </div>
  </div>
</body>
</html>
