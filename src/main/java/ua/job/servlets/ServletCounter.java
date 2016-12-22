package ua.job.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by MacBookPro on 12/16/16.
 */
public class ServletCounter extends HttpServlet{
    private int counter = 0;
    private AtomicInteger atomic = new AtomicInteger(0);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        synchronized (this){
            counter++;
        }
        // Третий способ
        int atomicCounter = atomic.incrementAndGet();


    }
}
