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
    <form action="<%=request.getContextPath()%>/User?action=create" method="post">
        Id: <input type="text" name="id">
        Name: <input type="text" name="name">
        <input type="submit" value="Create"><br>

    </form>
</div>

<div>Users table</div>
<table>
    <tr>

        <th>Id</th>
        <th>Name</th>
        <th>Edit name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <% for (User user : UserService.getInstance().getAll()) { %>
    <tr>
        <td><%= user.getId()%>
        </td>
        <td><%= user.getName()%>
        </td>
        <form action="<%= request.getContextPath()%>/User?action=edit&id=<%=user.getId()%>" method="post">
            <td><input type="text" name="editName"></td>
            <td><input type="submit" value="Edit"></td>
        </form>
        <form action="<%= request.getContextPath()%>/User?action=delete&id=<%=user.getId()%>" method="post">
            <td><input type="submit" value="Delete"></td>
        </form>
    </tr>
    <% } %>
</table>

</body>
</html>
