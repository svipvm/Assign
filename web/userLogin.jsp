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
  <title>任务提交 - 登录</title>
</head>
<body>
<div class="content-box">
  <div class="content left-style">
    <h1>任务提交 Topic</h1>
    <hr size="2" color="black">
    <ul>
      <li><p>一位成员可以加入多个小组</p></li>
      <li><p>一个小组中会有多个组长和成员</p></li>
      <li><p>成员只能在组长结束任务前提交任务</p></li>
      <li><p>一个任务可提交多次，并以最后一次为准</p></li>
      <li><p>成员不能擅自退出小组，组长能够移除</p></li>
      <li><p>成员可通过一组长提供的邀请码加入该小组</p></li>
      <li><p><font color="red">上传文件请等待提示上传完成后离开</font></p></li>
    </ul>
  </div>
  <div class="content right-style">
    <h1>用户登录</h1>
    <hr size="2" color="black">
    <form action="UserLoginServlet" method="post" onsubmit="return login_check()">
      <ul>
        <li><p>Account</p></li>
        <li><input class="text-input" id="account" type="text" name="account"></li>
        <li><p>Password</p></li>
        <li><input class="text-input" id="password" type="password" name="password"></li>
        <li><p><input class="login-bt" type="submit" value="登录"></p></li>
      </ul>
    </form>
<%--    <p class="message">Hello World!</p>--%>
    <p class="message">${message}</p>
  </div>
</div>
</body>
</html>
