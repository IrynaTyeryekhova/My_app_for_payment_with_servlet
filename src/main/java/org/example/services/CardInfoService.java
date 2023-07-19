package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.dbServices.DBCardService;
import org.example.dbServices.DBPaymentService;
import org.example.entities.CardAccount;
import org.example.entities.Payment;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CardInfoService {
    public static final Logger LOG=Logger.getLogger(CardInfoService.class.getName());

        public HttpServletRequest cardInfoMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
            LOG.info("CardInfoService is starting");
            HttpSession session = req.getSession();
            Service service = new Service();
            String language = service.getParameter(session, req, "lang");
            String cardNumber =  service.getParameter(session, req, "cardNumber");
            session.setAttribute("cardNumber", cardNumber);
            DBPaymentService paymentsService = DBPaymentService.getInstance();
            DBCardService cardService = DBCardService.getInstance();
            int countAllPayments = paymentsService.getCountAllPaymentsForCard(cardNumber);
            CardAccount cardAccount = cardService.getCardInfo(cardNumber);

            if(cardAccount == null || countAllPayments == -1) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req,resp);
            else {
                req = paymentForCardMake(countAllPayments, req, resp);

                session.setAttribute("cardInfoCardNumber",cardNumber);
                session.setAttribute("cardInfoValidityPeriod",cardAccount.getValidityPeriod());
                session.setAttribute("cardInfoBalance",cardAccount.getBalance());
                session.setAttribute("cardInfoStatus",cardAccount.getStatus());

                req.getRequestDispatcher("cardsInfo.jsp?lang=" + language).forward(req, resp);
            }
            return req;
        }
        private HttpServletRequest paymentForCardMake(int countAllPayments, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession();
            Service service = new Service();
            String language = service.getParameter(session, req, "lang");
            PaginationService paginationService = new PaginationService();
            paginationService.paginationParameterSortMake(req, "paramSortPaymentsForCardList","selectParamSortPaymentForCard", "id", "date", "sum");
            paginationService.paginationMake(req, countAllPayments);

            Integer limit = Integer.valueOf(String.valueOf(session.getAttribute("selectCountShow")));
            Integer numberPage = Integer.valueOf(String.valueOf(session.getAttribute("numberPage")));

            int offSet = (numberPage * limit) - limit;

            DBPaymentService paymentsService = DBPaymentService.getInstance();
            List<Payment> payments = paymentsService.findAllPaymentsForCardWithLimit((String) session.getAttribute("cardNumber"), "payments." + (String) session.getAttribute("selectParamSortPaymentForCard"), (String) session.getAttribute("selectParamSortType"), limit, offSet);

            if (payments == null) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req, resp);
            else session.setAttribute("paymentsForCard", payments);

            return req;
            }
    }







