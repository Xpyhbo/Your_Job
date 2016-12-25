package ua.job.servlets;

import ua.job.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vasyl on 12/25/16.
 */
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String user = req.getParameter("user");
        String admin = req.getParameter("admin");
        HttpSession session = req.getSession();

        synchronized (session){
            session.setAttribute("login", login);
            session.setAttribute("password", password);
        }
        resp.sendRedirect(String.format("%s/views/Application.jsp", req.getContextPath()));



    }
}
