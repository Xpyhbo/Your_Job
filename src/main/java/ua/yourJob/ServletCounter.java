package ua.yourJob;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.List;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by MacBookPro on 12/16/16.
 */
public class ServletCounter extends HttpServlet{
    private int counter = 0;
    private AtomicInteger atomic = new AtomicInteger(0);
    private volatile int volatileCounter = 0;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        // Первый способ, думаю что упадет производительность из за того что обьект-монитор будет блокироваться.
        synchronized (req){
            counter++;
        }
        // Второй способ
        req.getParameter("param");
        try
        {
            Thread.currentThread().sleep((long)Math.random() * 100);
            counter++;
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        // Третий способ
        int atomicCounter = atomic.incrementAndGet();
        //четвертый способ
        volatileCounter++;
        // Хотел как сделать через синхронизированный список но не смог
        //List<HttpServletRequest> list = Collections.synchronizedList(new ArrayList<HttpServletRequest>());
        //пишет java.awt.list does not have any parameteres
        //Помоги с етой реализацией.
    }
}
