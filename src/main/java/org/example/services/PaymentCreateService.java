package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.dbServices.DBCardService;
import org.example.dbServices.DBPaymentService;
import org.example.entities.CardAccount;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PaymentCreateService {
    public static final Logger LOG = Logger.getLogger(PaymentCreateService.class.getName());

    public HttpServletResponse paymentAddMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
        LOG.info("PaymentCreateService is starting");
        HttpSession session = req.getSession();
        Service service = new Service();
        DBCardService cardService = DBCardService.getInstance();
        String language = service.getParameter(session, req, "lang");
        String choiceCardNumber = service.getParameter(session, req, "choiceCardNumber");
        String paymentSum = service.getParameter(session, req, "paymentSum");
        String purposePayment = service.getParameter(session, req, "purposePayment");
        String cardPasswordAddPayment = service.getParameter(session, req, "cardPasswordAddPayment");
        String eMail = service.getParameter(session, req, "ClientEMail");

        if (choiceCardNumber == null)
            req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=choiceCardNumberEmpty").forward(req, resp);
        else {
            CardAccount cardAccount = cardService.getCardInfo(choiceCardNumber);
            if (cardAccount == null) resp.sendRedirect("/paymentCreate?lang=" + language +  "&message=error");
            else if (cardAccount.getBalance() < Double.valueOf(paymentSum)) {
                req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=insufficientBalance").forward(req, resp);
            } else if (!cardAccount.getPassword().equals(cardPasswordAddPayment)) {
                req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=cardPasswordAddPaymentNotEquals").forward(req, resp);
            } else {
                DBPaymentService paymentsService = DBPaymentService.getInstance();
                int insertPayment = paymentsService.insertPayment(Double.valueOf(paymentSum), purposePayment, eMail, choiceCardNumber);

                if (insertPayment > 0) resp.sendRedirect("/paymentCreate?lang=" + language + "&message=addPayment");
                else if (insertPayment == 0)
                    resp.sendRedirect("/paymentCreate?lang=" + language + "&message=addPaymentErr");
            }
        }
        return resp;
    }
}
