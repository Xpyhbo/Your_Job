package ua.job.servlets;

import ua.job.model.ApplicationForm;
import ua.job.services.ApplicationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vasyl on 12/25/16.
 */
public class ApplicationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = req.getParameter("fio");
        String speciality = req.getParameter("speciality");
        String experience = req.getParameter("experience");
        String contacts = req.getParameter("contacts");
        String action = req.getParameter("action");

        if (action.equals("application")){
            ApplicationService.getInstance().add(new ApplicationForm(fio, speciality, experience, contacts));
        }

        resp.sendRedirect(req.getContextPath()+"/views/Application.jsp");
    }
}
