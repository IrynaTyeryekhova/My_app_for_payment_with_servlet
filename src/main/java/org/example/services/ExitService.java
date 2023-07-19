package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ExitService {
    public static final Logger LOG=Logger.getLogger(ExitService.class.getName());
    public HttpServletRequest exitMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("ExitService is starting");
        HttpSession session = req.getSession();
        session.invalidate();
        String language = req.getParameter("lang");
        req.getRequestDispatcher("index.jsp?lang=" + language).forward(req, resp);
        return req;
    }
}
