package ua.yourJob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

public class FirstServlet extends HttpServlet {
    private ArrayList<User> users = new ArrayList<User>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String param = req.getParameter("name");
        resp.getWriter().write("<h3>Create user:</h3>" +
                "<form action='/job2/FirstServlet' method='post'>" +
                "First name: <input type='text' name='name'/><br>"+
                "Id: <input type='text' id ='id'/>"+
                "</form>");
        resp.getWriter().write("<h3>Edit user:</h3>" +
                "<form action='/job2/FirstServlet' method='put'>" +
                "Type user name: <input type='text' name='name'/><br>"+
                "Id: <input type='text' id ='id'/>"+
                "</form>");
        resp.getWriter().write("<h3>Delete user:</h3>" +
                "<form action='/job2/FirstServlet' method='delete'>" +
                "Type user name: <input type='text' name='name'/><br>"+
                "</form>");
        resp.getWriter().write("<h3>Show users:</h3>" +
                "<form action='/job2/FirstServlet' method='get'>" +
                "<button type='submit' name='submit'>Show users</button>"+
                "</form>");
        String value = req.getParameter("submit");
        if (users == null){
            resp.getWriter().write("List is empty");
        }
        else {
            for (User usersList : users){
                resp.getWriter().write(usersList.getName());
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String userName = req.getParameter("name");
        int id = Integer.valueOf(req.getParameter("id"));
        User user = new User();
        user.setName(userName);
        user.setId(id);
        users.add(user);
        resp.getWriter().write("User Name: "+user.getName()+
                " User id: "+String.valueOf(user.getId()));

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        int currentId = Integer.valueOf(req.getParameter("id"));

         for (User list : users){
            if (list.getId()==currentId)
             list.setName(req.getParameter("name"));

        }

    }
//get
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Iterator<User> iterator = users.iterator();
        String currentName = req.getParameter("name");
        if (users == null) {
            resp.getWriter().write("Nothing to delete. No users found");
        }
        else {
            while (iterator.hasNext()) {
                User user = iterator.next();
                if (user.getName().toLowerCase() == currentName.toLowerCase())
                    iterator.remove();
            }
            resp.getWriter().write(currentName + " has been deleted from the list ");
        }
    }
    }

