package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.dbServices.DBPaymentService;
import org.example.entities.Payment;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class PaymentMenuService {
    public static final Logger LOG=Logger.getLogger(PaymentMenuService.class.getName());

        public HttpServletRequest paymentMenuMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
            LOG.info("PaymentMenuService is starting");
            HttpSession session = req.getSession();
            Service service = new Service();
            String email = service.getParameter(session, req, "ClientEMail");
            String language = service.getParameter(session, req, "lang");

            PaginationService paginationService = new PaginationService();
            paginationService.paginationParameterSortMake(req, "paramSortPaymentList","selectParamSortPayments","id", "date", "sum");

            DBPaymentService paymentsService = DBPaymentService.getInstance();
            int countAllPaymentsForClient = paymentsService.getCountAllPaymentsForClient(email);

            if(countAllPaymentsForClient == -1) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req,resp);
            else {
                paginationService.paginationMake(req, countAllPaymentsForClient);

                Integer limit = Integer.valueOf(String.valueOf(session.getAttribute("selectCountShow")));
                Integer numberPage = Integer.valueOf(String.valueOf(session.getAttribute("numberPage")));

                int offSet = (numberPage * limit) - limit;

                ArrayList<Payment> payments = paymentsService.findAllPayments(email, "payments." + (String) session.getAttribute("selectParamSortPayments"), (String) session.getAttribute("selectParamSortType"), limit, offSet);

                if (payments == null) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req, resp);
                else {
                    session.setAttribute("payments", payments);
                    req.getRequestDispatcher("paymentsInfo.jsp?lang=" + language).forward(req, resp);
                }
            }return req;
        }
    }

