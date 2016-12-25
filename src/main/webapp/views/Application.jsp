<%@ page import="ua.job.model.ApplicationForm" %>
<%@ page import="ua.job.services.ApplicationService" %><%--
  Created by IntelliJ IDEA.
  User: vasyl
  Date: 12/25/16
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application form</title>
</head>
<body>
        Hello, <%= session.getAttribute("login")%>
    <form action="<%= request.getContextPath()%>/application?action=application" method="post">
        Full name: <input type="text" name="fio"><br>
        Speciality: <input type="text" name="speciality"><br>
        Experience: <textarea name="experience" cols="40" rows="5"></textarea><br>
        Contacts: <textarea name="contacts" cols="40" rows="5"></textarea><br>
        <input type="submit">
    </form>


    <table>
        <tr>
        <th>Full name</th>
        <th>Speciality</th>
        <th>Experience</th>
        <th>Contacts</th>
        </tr>
        <% for(ApplicationForm form : ApplicationService.getInstance().getAll()) { %>
        <tr>
            <td> <%= form.getFio() %></td>
            <td> <%= form.getSpeciality() %></td>
            <td> <%= form.getExperience() %></td>
            <td> <%= form.getContacts() %></td>
        </tr>
        <% } %>

    </table>


</body>
</html>
