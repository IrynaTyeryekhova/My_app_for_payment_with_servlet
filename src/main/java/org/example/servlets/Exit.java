package org.example.servlets;

import org.apache.log4j.Logger;
import org.example.services.ExitService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/exit")
public class Exit extends HttpServlet{
    public static final Logger LOG=Logger.getLogger(Exit.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        try {
            req = new ExitService().exitMake(req, resp);
        } catch (ServletException e) {
            LOG.info("Exit. ServletException");
        } catch (IOException e) {
            LOG.info("Exit. IOException");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }
    }

