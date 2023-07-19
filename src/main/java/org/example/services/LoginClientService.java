package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.Roles;
import org.example.Statuses;
import org.example.dbServices.DBClientService;
import org.example.entities.Client;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginClientService {
  public static final Logger LOG=Logger.getLogger(LoginClientService.class.getName());

    public HttpServletResponse loginClientChecking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
        LOG.info("Login Client is starting");
        HttpSession session = req.getSession();
        DBClientService clientService = DBClientService.getInstance();
        String name;
        boolean equalsResult;

        String eMail = new Service().getParameter(session, req, "ClientEMail");
        String password = new Service().getParameter(session, req, "Password");
        String language = new Service().getParameter(session, req, "lang");
        String action = new Service().getParameter(session, req, "action");

        if (action.equals("login") ) {
                equalsResult = clientService.equalsClientPassword(eMail, password);
                Client client = clientService.getClientInfo(eMail);
                if (client == null) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req, resp);
                else if (equalsResult && client.getStatus().equals(Statuses.UNBLOCK_STRING)) {

                    name = client.getName();
                    String greeting = new Service().helloMake(name);

                    session.setAttribute("ClientEMail", eMail);
                    session.setAttribute("Password", password);
                    session.setAttribute("ClientName", name);
                    session.setAttribute("hello", greeting);

                    if(client.getRole().equals(Roles.USER_STRING)) {
                        LOG.info("Login client. Client role: user");
                        resp.sendRedirect("/register?lang=" + language);
                    } else {
                        session.setAttribute("ClientRole", Roles.ADMIN_STRING);
                        LOG.info("Login client. Client role: admin");
                        resp.sendRedirect("adminCardsMenu.jsp?lang=" + language);
                    }
                } else if (!equalsResult) {
                    req.getRequestDispatcher("/infoLoginMessage?lang=" + language + "&message=loginErr").forward(req, resp);
                } else if (client.getStatus().equals(Statuses.BLOCK_STRING)) {
                    req.getRequestDispatcher("/infoLoginMessage?lang=" + language + "&message=loginBlockErr").forward(req, resp);
                }
        }
        return resp;
    }
    public HttpServletRequest loginDoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return req;
    }
}
