package org.example.servlets;

import org.apache.log4j.Logger;
import org.example.ErrorsMessage;
import org.example.services.Service;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/infoLoginMessage")
public class InfoLoginMessage extends HttpServlet{
    public static final Logger LOG=Logger.getLogger(InfoLoginMessage.class.getName());

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            String message = new Service().getParameter(session, req, "message");
            String infoMessage = "";

            if(message.equals("registerDuplicate")) {
                LOG.info("Client registration: client duplicate");
                infoMessage = ErrorsMessage.REGISTER_DUPLICATE_CLIENT_ERR;
            }
            else if(message.equals("loginErr")) {
                LOG.info("Login client. Login error");
                infoMessage = ErrorsMessage.LOGIN_INFO_ERR;
            }
            else if(message.equals("loginBlockErr")) {
                LOG.info("Login client. Login block error");
                infoMessage = ErrorsMessage.LOGIN_BLOCK_USER_ERR;
            }

            session.setAttribute("infoMessage", infoMessage);
            session.setAttribute("message", message);

            req.getRequestDispatcher("accessMessagePage.jsp?lang=" + req.getParameter( "lang")).forward(req, resp);
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req,resp);
        }
    }
