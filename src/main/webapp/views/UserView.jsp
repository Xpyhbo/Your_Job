<%@ page import="ua.job.model.User" %>
<%@ page import="ua.job.services.UserService" %><%--
  Created by IntelliJ IDEA.
  User: MacBookPro
  Date: 12/16/16
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User View</title>
</head>
<body>
<div>
    <form action="<%=request.getContextPath()%>/views/UserView.jsp " method="post">
        Name: <input type="text" name="name">
        Surname: <input type="text" name="surname">
        <input type="submit" name="create"value="Create">
    </form>
</div>

<%

    String name = request.getParameter("name");
    String surName = request.getParameter("surname");
    String parameter = "";
    if (request.getParameterMap().containsKey("create")){
        parameter = request.getParameter("create");
        UserService.getInstance().addUser(new User(name, surName));
    }
    else if (request.getParameterMap().containsKey("edit")){
     UserService.getInstance().editUser(request.getParameter("oldSurName"));
    }
    else if (request.getParameterMap().containsKey("delete")){
        UserService.getInstance().deleteUser(request.getParameter("surname"));

    }
%>
<div>Users table</div>
<table>

    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Edit Field</th>
        <th>Delete Field</th>
    </tr>
    <form action="<%= request.getContextPath()%>/views/UserView.jsp" method="post">
    <% for (User user : UserService.getInstance().getAll()) { %>
    <tr>
        <td><%= user.getId()%></td>
        <td><%= user.getName()%></td>
        <td><%= user.getSurName()%></td>
        <td><input type="submit" name="edit" value="Edit"></td>
        <td><input type="submit" name="delete" value="Delete"></td>
    </tr>
    <% } %>
        </form>
</table>

</body>
</html>
