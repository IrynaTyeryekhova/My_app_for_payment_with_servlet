package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.Statuses;
import org.example.dbServices.DBCardService;
import org.example.entities.CardAccount;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class PaymentCreateInfoService {
    public static final Logger LOG=Logger.getLogger(PaymentCreateInfoService.class.getName());
    public HttpServletRequest paymentAddInfoMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
        LOG.info("PaymentCreateInfoService is starting");
        HttpSession session = req.getSession();
        Service service = new Service();
        DBCardService cardService = DBCardService.getInstance();
        String language = service.getParameter(session, req,"lang");
        String eMail = service.getParameter(session, req,"ClientEMail");

        List<CardAccount> cards = cardService.findAllCardClientForStatus(eMail, Statuses.UNBLOCK);

        if(cards != null) {
        session.setAttribute("selectCardNumber", cards);
        req.getRequestDispatcher("paymentAddInfo.jsp?lang=" + language).forward(req, resp);
        } else req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req,resp);
        return req;
     }
}
