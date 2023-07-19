package org.example.services;

import org.apache.log4j.Logger;
import org.example.dbServices.DBCardService;
import org.example.entities.CardAccount;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CardMenuService {
    public static final Logger LOG=Logger.getLogger(CardMenuService.class.getName());
    public HttpServletRequest cardMenuMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            LOG.info("CardMenuService/cardMenuMake is starting");
            HttpSession session = req.getSession();
            String language = new  Service().getParameter(session, req,"lang");
            String parametrSort =  new Service().getParameter(session,req, "actualParamSortCardMenu");

            if(parametrSort==null) {parametrSort = "balance";}
            session.setAttribute("actualParamSortCardMenu", parametrSort);

            List<String> paramSortList = Arrays.asList("balance", "number", "validity_period");
            session.setAttribute("paramSortListCardMenu", paramSortList);

            DBCardService cardService = DBCardService.getInstance();
            List<CardAccount> cardAccounts = cardService.findAllCardForClient((String) session.getAttribute("ClientEMail"));
            if (cardAccounts != null) {
               cardAccounts = sortCard(cardAccounts, parametrSort);
               session.setAttribute("cardAccountsForCardMenu", cardAccounts);
               req.getRequestDispatcher("cardsMenu.jsp?lang=" + language).forward(req, resp);
            } else req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req, resp);

            return req;
        }
        private List<CardAccount> sortCard(List<CardAccount> cardAccounts, String parametrSort) {
            if(parametrSort==null||parametrSort.equals("balance")) {
                cardAccounts= cardAccounts
                        .stream()
                        .sorted(Comparator.comparing(s->s.getBalance()))
                        .collect(Collectors.toList());}
            else if(parametrSort.equals("number")) {
                cardAccounts= cardAccounts
                        .stream()
                        .sorted(Comparator.comparing(s->s.getNumber()))
                        .collect(Collectors.toList());}
            else {
                cardAccounts= cardAccounts
                        .stream()
                        .sorted(Comparator.comparing(s->s.getValidityPeriod()))
                        .collect(Collectors.toList());
            }
            return cardAccounts;
        }

    }




