package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.dbServices.DBCardService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CardBalanceService {
    public static final Logger LOG=Logger.getLogger(CardBalanceService.class.getName());

        public HttpServletResponse cardBalanceMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
            LOG.info("CardBalanceService is starting");
            HttpSession session = req.getSession();
            Service service = new Service();
            String cardNumber = service.getParameter(session, req, "cardNumber");
            String newBalance = service.getParameter(session, req, "newBalance");
            String passwordCard = service.getParameter(session, req, "passwordCard");
            String language = service.getParameter(session, req,  "lang");
            String action = service.getParameter(session, req,  "action");

            DBCardService cardService = DBCardService.getInstance();
            int balanceChange;
            if (action.equals("balanceChange")){
                balanceChange = cardService.cardBalanceChange(cardNumber,Double.valueOf(newBalance),passwordCard, true);

                if (balanceChange==0) {req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=cardBalanceChangeErr").forward(req, resp);
                } else if (balanceChange==2) {req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=cardBalanceChangeErrPassword").forward(req, resp);}

            }
            resp.sendRedirect("/cardBalanceChange?lang=" + language + "&message=balance");
            return resp;
        }
}
