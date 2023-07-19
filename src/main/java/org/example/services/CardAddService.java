package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.dbServices.DBCardService;
import org.example.entities.CardAccount;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CardAddService {
    public static final Logger LOG=Logger.getLogger(CardAddService.class.getName());
        public HttpServletResponse cardAddInfoMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
            LOG.info("CardAddService is starting");
            HttpSession session = req.getSession();
            Service service = new Service();

            String cardNumberAdd = service.getParameter( session,req,"cardNumberAdd");
            session.setAttribute("cardNumberAdd", cardNumberAdd);
            String cardBalance = service.getParameter( session,req, "cardBalance");
            String cardPeriod = service.getParameter( session,req, "cardPeriod");
            String cardPassword = service.getParameter( session,req,"cardPassword");
            String language = service.getParameter(session, req,"lang");
            String action = service.getParameter( session, req, "action");
            String email = service.getParameter( session, req,"ClientEMail");

            int insertResult;
            if (action.equals("cardAdd")){
                DBCardService cardService = DBCardService.getInstance();
                insertResult = cardService.insertCard(new CardAccount(cardNumberAdd, Double.valueOf(cardBalance), cardPeriod, cardPassword), email);
                if (insertResult == 0) req.getRequestDispatcher("/infoMessage?lang=" + language + "&mess=insertCardErr").forward(req, resp);
            }
            resp.sendRedirect("/cardAdd?lang=" + language + "&mess=card");
            return resp;
        }
    }

