<%--
  Created by IntelliJ IDEA.
  User: MacBookPro
  Date: 12/16/16
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jsp file</title>
</head>
<body>
    <% if (session.isNew()) { %>
    <form action="<%= request.getContextPath()%>/login" method="post">
        Who Are you: <select>
        <option name="admin">Admin</option>
        <option name="user">User</option>
    </select><br>
        Login:    <input type="text" name="login"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="submit">
    </form>
    <% } else { %>
        Welcome back, <%= session.getAttribute("login")%>  <a href="<%=request.getContextPath()%>/logout">Logout</a>
    <% } %>


  <div><a href="<%=request.getContextPath()%>/views/UserView.jsp">Users</a></div>
</body>
</html>
