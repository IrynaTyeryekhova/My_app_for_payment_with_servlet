package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.Roles;
import org.example.dbServices.DBClientService;
import org.example.entities.Client;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterClientService {
    public static final Logger LOG=Logger.getLogger(RegisterClientService.class.getName());
        public HttpServletResponse registerClientMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, DBException {
            HttpSession session = req.getSession();
            String language = new Service().getParameter(session, req, "lang");
            String action = new Service().getParameter(session, req, "action");

            if (action.equals("registration") ) {

                String eMail = new Service().getParameter(session, req, "ClientEMail");
                String password = new Service().getParameter(session, req, "Password");
                String name = new Service().getParameter(session, req, "ClientName");

                LOG.info("Client registration is starting");
                DBClientService dbClientService = DBClientService.getInstance();
                int insertResult = dbClientService.insertClient(new Client(eMail, password, name));

                if (insertResult == 0) {
                    req.getRequestDispatcher("/infoLoginMessage?lang=" + language + "&message=registerDuplicate").forward(req, resp);
                } else LOG.info("Client registration was successful");

                session.setAttribute("ClientEMail", eMail);
                session.setAttribute("Password", password);
                session.setAttribute("ClientName", name);

                String greeting = new Service().helloMake(name);
                session.setAttribute("hello", greeting);
            }
            session.setAttribute("ClientRole", Roles.USER_STRING);
            resp.sendRedirect("/register?lang=" + language);

            return resp;
        }

        public HttpServletRequest registerDoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            String language = new Service().getParameter(session, req, "lang");

            req.getRequestDispatcher("personalOffice.jsp?lang=" + language).forward(req, resp);
            return req;
        }
}
