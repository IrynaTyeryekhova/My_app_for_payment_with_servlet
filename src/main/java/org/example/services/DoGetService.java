package org.example.services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoGetService {
    public HttpServletRequest doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String reqMess = "/infoMessage?lang=" + req.getParameter( "lang")+"&message=" + req.getParameter( "message");
        req.getRequestDispatcher(reqMess).forward(req, resp);
        return req;
    }
}
