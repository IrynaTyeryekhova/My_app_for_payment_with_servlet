package org.example.services;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CardStatusInfoService {
    public static final Logger LOG=Logger.getLogger(CardStatusInfoService.class.getName());

    public HttpServletRequest cardStatusInfoMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            LOG.info("CardStatusInfoService is starting");
            HttpSession session = req.getSession();
            String language = req.getParameter( "lang");
            String status = (String) session.getAttribute("cardInfoStatus");
            String statusChangeMessage = "";
            String button = "";
            if(status.equals("unblock")) {
                    statusChangeMessage = "message.statusChangeMessageBlock";
                    button = "button.block";
            } else {
                    statusChangeMessage = "message.statusChangeMessageUnblock";
                    button = "button.unblock";
            }

           session.setAttribute("StatusChangeMessage", statusChangeMessage);
           session.setAttribute("ButtonChangeStatus", button);

           req.getRequestDispatcher("cardStatusChange.jsp?lang=" + language).forward(req, resp);
           return req;
        }
    }
