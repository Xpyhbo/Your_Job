package ua.job.servlets;

import ua.job.services.UserService;
import ua.job.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vasyl on 12/23/16.
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String edit = request.getParameter("editName");
        String action = request.getParameter("action");
        String userId = request.getParameter("id");
        String name = request.getParameter("name");


        if (action.equals("create"))
            UserService.getInstance().addUser(new User(userId, name));
        else if (action.equals("delete"))
            UserService.getInstance().deleteUser(userId);
        else if (action.equals("edit"))
            UserService.getInstance().editUser(userId, edit);

        resp.sendRedirect(request.getContextPath()+"/views/UserView.jsp");
    }
}

