package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.Statuses;
import org.example.dbServices.DBPaymentService;
import org.example.entities.Payment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class PaymentPreparedService {
    public static final Logger LOG = Logger.getLogger(PaymentPreparedService.class.getName());

    public HttpServletRequest paymentPreparedMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
        LOG.info("PaymentPreparedService is starting");
        HttpSession session = req.getSession();
        Service service = new Service();
        String email = service.getParameter(session, req, "ClientEMail");
        String language = service.getParameter(session, req, "lang");
        DBPaymentService paymentsService = DBPaymentService.getInstance();

        PaginationService paginationService = new PaginationService();
        paginationService.paginationParameterSortMake(req, "paramSortPaymentPreparedList", "selectParamSortPreparedPayments", "id", "date", "sum");

        int countAllPaymentsForStatus = paymentsService.getCountAllPaymentsForStatus(email, Statuses.PREPARED);
        if (countAllPaymentsForStatus == -1) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req, resp);
        else {
            paginationService.paginationMake(req, countAllPaymentsForStatus);

            Integer limit = Integer.valueOf(String.valueOf(session.getAttribute("selectCountShow")));
            Integer numberPage = Integer.valueOf(String.valueOf(session.getAttribute("numberPage")));

            int offSet = (numberPage * limit) - limit;

            List<Payment> payments = paymentsService.findAllPaymentsForStatus(email, Statuses.PREPARED, "payments." + (String) session.getAttribute("selectParamSortPreparedPayments"), (String) session.getAttribute("selectParamSortType"), limit, offSet);
            if (payments == null) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req, resp);
            else {
                session.setAttribute("paymentsPrepared", payments);
                req.getRequestDispatcher("paymentPreparedSend.jsp?lang=" + language).forward(req, resp);
            }
        }
        return req;
    }
}