package ua.job.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by MacBookPro on 12/16/16.
 */

public class FirstServlet extends HttpServlet {
    private static ArrayList<User> users = new ArrayList<User>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        StringBuilder sb = new StringBuilder();
        Writer writer = resp.getWriter();
        writer.write(sb.append("<h3>Create user:</h3>" )
                .append("<form action='/job2/FirstServlet' method='POST'>")
                .append("First name:<br>")
                .append("<input type='text' name='name'/><br>")
                .append("Id:<br>")
                .append("<input type='text' name='id'/><br>")
                .append("Amount of money to declare:<br>")
                .append("<input type='text' name='money'/><br>")
                .append("Trip date: (D-M-Y)<br>")
                .append("<input type='text' name='date'/><br>")
                .append("Items: (Type with whitespace)<br>")
                .append("<textarea type='text' name='items' rows='3' cols='40'></textarea><br>")
                .append("<button type='submit' name='submit'>Create user</button>")
                .append("</form>").toString());
        sb.delete(0, sb.length());
        writer.write(sb.append("<h3>Edit user:</h3>")
                .append("<form action='/job2/FirstServlet' method='PUT'>")
                .append("Type user name: <input type='text' name='name'/><br>")
                .append("Id: <input type='text' name='id'/><br>")
                .append("<button type='submit' name='submit'>Edit user</button>")
                .append("</form>").toString());
        sb.delete(0, sb.length());
        writer.write(sb.append("<h3>Delete user:</h3>" )
                .append("<form action='/job2/FirstServlet' method='DELETE'>")
                .append("Type user name: <input type='text' name='name'/><br>")
                .append("<button type='submit' name='submit'>Delete user</button>")
                .append("</form>").toString());
        sb.delete(0, sb.length());
        writer.write(sb.append("<h3>Show users:</h3>")
                .append("<form action='/job2/FirstServlet' method='GET'><br>")
                .append("<button type='submit' name='submit'>Show users</button>")
                .append("</form><br>").toString());
        sb.delete(0, sb.length());
        if (users.isEmpty())
            writer.write("List is empty");
        else {
            for (User usersList : users){
                writer.write(usersList.getName()+"\n");
            }
        }
        writer.flush();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        try {
            String userName = req.getParameter("name");
            int id = Integer.valueOf(req.getParameter("id"));
            float money = Float.valueOf(req.getParameter("money"));
            String[] items = req.getParameter("items").split(" ");
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            Date tripDate = date.parse(req.getParameter("date").toString());
            User user = new User();
            user.setName(userName);
            user.setId(id);
            user.setItems(items);
            user.setTrip(tripDate);
            user.setMoney(money);
            users.add(user);
            writer.write(new StringBuilder("model Name: ")
                    .append(user.getName()).append("<br>")
                    .append(" model id: ").append(user.getId()).append("<br>")
                    .append("Trip date: ").append(user.getTrip()).append("<br>")
                    .append("Money to declare: ").append(user.getMoney()).append("$<br>")
                    .append("Items for travel: ").toString());
            for (String item : items) {
                writer.write(item + ", ");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        writer.flush();
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        String name = req.getParameter("name");
        int currentId = Integer.valueOf(req.getParameter("id"));
        String submitPar = req.getParameter("submit");
        if(submitPar.equals("submit")) {
            for (User list : users) {
                if (list.getId() == currentId)
                    list.setName(name);
                writer.write("model with " + currentId + " has been updated");
            }
        }
        writer.flush();
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        Iterator<User> iterator = users.iterator();
        String currentName = req.getParameter("name");
        if (users.isEmpty())
            writer.write("Nothing to delete. No users found");
        else {
            while (iterator.hasNext()) {
                User user = iterator.next();
                if (user.getName().toLowerCase().equals(currentName.toLowerCase()))
                    iterator.remove();
            }
            writer.write(currentName + " has been deleted from the list ");
        }
        writer.flush();
    }
    }

