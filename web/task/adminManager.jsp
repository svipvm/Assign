<%@ page import="com.demo.vo.Admin" %>
<%@ page import="com.demo.vo.Muster" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.demo.vo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: SvipVM
  Date: 2020/10/15
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link type="text/css" rel="stylesheet" href="../css/struct_style.css">
  <link type="text/css" rel="stylesheet" href="../css/model_style.css">
  <title>Title</title>
</head>
<body>
  <jsp:include page="/task/AdminManagerServlet"/>
  <%String ID = request.getParameter("groupID");%>
  <%ArrayList<User> users = (ArrayList<User>) session.getAttribute("admin-member");%>
<%--  <%Muster muster = (Muster) session.getAttribute("admin-group");%>--%>
  <div id="admin-return"><a href="index.jsp">返回首页</a></div>
<%--  <font color="red"><%=request.getParameter("groupID")%></font>--%>
  <div id="admin-manager">
    <h1>管理 - 小组：<%=ID%></h1>
    <hr>
    <div id="admin-manager-roll">
      <form>
        <table>
          <tr><th>ID</th><th>姓名</th><th>操作</th></tr>
          <tr>
            <td><input type="text"></td>
            <td>输入ID添加</td>
            <td><button type="button">添加成员</button></td>
          </tr>
          <%if(users != null) {%>
            <%for(User user : users) {%>
              <tr>
                <td><%=user.getAccount()%></td>
                <td><%=user.getName()%></td>
                <td><button type="button">踢出小组</button></td>
              </tr>
            <%}%>
          <%}%>
        </table>
      </form>
    </div>
  </div>
</body>
</html>
