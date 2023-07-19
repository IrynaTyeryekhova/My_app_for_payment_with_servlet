package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.Statuses;
import org.example.dbServices.DBCardService;
import org.example.dbServices.DBPaymentService;
import org.example.entities.CardAccount;
import org.example.entities.Payment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class PaymentSendService {
    public static final Logger LOG = Logger.getLogger(PaymentSendService.class.getName());

    public HttpServletResponse paymentSendMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
        LOG.info("PaymentSendService is starting");
        HttpSession session = req.getSession();
        Service service = new Service();
        String language = service.getParameter(session, req, "lang");
        int paymentIdSend = Integer.parseInt(String.valueOf(service.getParameter(session, req, "paymentIdSend")));

        DBPaymentService paymentsService = DBPaymentService.getInstance();
        DBCardService cardService = DBCardService.getInstance();
        Payment payment = paymentsService.getPaymentInfo(paymentIdSend);
        CardAccount cardAccount = cardService.getCardInfo(payment.getCardNumber());

        if (cardAccount == null || payment == null) resp.sendRedirect("/paymentSend?lang=" + language + "&message=error");
        else {
            String paymentStatus = payment.getStatus();

            if (cardAccount.getStatus().equals("block"))
                resp.sendRedirect("/paymentSend?lang=" + language + "&message=paymentSentCardBlockErr");
            else if (payment.getSum() <= cardAccount.getBalance() && paymentStatus.equals("prepared")) {
                int cardBalanceChangeResult = cardService.cardBalanceChange(payment.getCardNumber(), cardAccount.getBalance() - payment.getSum(), "", false);
                int updatePaymentStatusResult = paymentsService.updatePaymentStatus(paymentIdSend, Statuses.SENT);
                if (cardBalanceChangeResult > 0 && updatePaymentStatusResult > 0)
                    resp.sendRedirect("/paymentSend?lang=" + language + "&message=paymentSent");
                else resp.sendRedirect("/paymentSend?lang=" + language + "&message=error");
            } else if (paymentStatus.equals("sent"))
                resp.sendRedirect("/paymentSend?lang=" + language + "&message=paymentSentDuplicateErr");
            else
                req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=paymentSentErr").forward(req, resp);
        }
        return resp;
    }
}
