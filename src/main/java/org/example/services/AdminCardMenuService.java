package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.dbServices.DBCardService;
import org.example.dbServices.DBClientService;
import org.example.Roles;
import org.example.Statuses;
import org.example.entities.CardAccount;
import org.example.entities.Client;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminCardMenuService {
    public static final Logger LOG=Logger.getLogger(AdminCardMenuService.class.getName());
        public HttpServletRequest AdminCardMenuMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
            LOG.info("AdminCardMenuService is starting");
            HttpSession session = req.getSession();
            Service service = new Service();
            String language = service.getParameter(session, req, "lang");
            String action = service.getParameter(session,req, "action");
            DBCardService cardService = DBCardService.getInstance();
            DBClientService clientService = DBClientService.getInstance();

            PaginationService paginationService = new PaginationService();
            if(action.equals("blockUnblockClient")) {paginationService.paginationParameterSortMake(req, "paramSortClientsList", "selectParamSortClients","clients.e_mail", "clients.name");}
            else {paginationService.paginationParameterSortMake(req, "paramSortCardsList","selectParamSortCards","number", "balance", "validity_period");}

            List<CardAccount> cardsForRequestAdmin = cardService.findAllCardForRequestAdmin(Statuses.NEW);
            List<CardAccount> cards = new ArrayList<>();
            List<Client> clients = clientService.findAllClientsForRole(Roles.USER);
            int findCountAllCard = cardService.findCountAllCard();

            if(action.equals("blockUnblockCards")) {
                if(findCountAllCard != -1) paginationService.paginationMake(req, findCountAllCard);
            } else if(action.equals("blockUnblockClient")) {
                if (clients != null) paginationService.paginationMake(req, clients.size());
            } else {
                if (cardsForRequestAdmin != null) paginationService.paginationMake(req, cardsForRequestAdmin.size());
            }
            Integer limit = Integer.valueOf(String.valueOf(session.getAttribute("selectCountShow")));
            Integer numberPage = Integer.valueOf(String.valueOf(session.getAttribute("numberPage")));

            int offSet = (numberPage * limit) - limit;
//
//            String getAllRequestAdmin = "";

            if (action.equals("blockUnblockClient")) {
                clients = clientService.findAllClientsForRole(Roles.USER, (String) session.getAttribute("selectParamSortClients"), (String) session.getAttribute("selectParamSortType"), limit, offSet);
//                getAllRequestAdmin = new Service()
//                        .getAllClientsInfoUkr(clientService.findAllClientsForRole(Roles.USER, (String) session.getAttribute("parametrSortClient"), (String) session.getAttribute("parametrSortType"), limit, offSet));
            } else if (action.equals("blockUnblockCards")) {
                cards = cardService.findAllCardWithLimit((String) session.getAttribute("selectParamSortCards"), (String) session.getAttribute("selectParamSortType"), limit, offSet);
//                if (cards != null && language.equals("ukr")) {
//                    getAllRequestAdmin = new Service().getAllCardsInfoUkr(cards,  true, true);
//                } else if (cards != null && language.equals("eng")) {
//                    getAllRequestAdmin = new Service().getAllCardsInfoEng(cards,  true, true);
//                }
            } else {
                cardsForRequestAdmin = cardService.findAllCardForRequestAdmin(Statuses.NEW, "cards." + (String) session.getAttribute("selectParamSortCards"), (String) session.getAttribute("selectParamSortType"), limit, offSet);
//                if (cards != null && language.equals("ukr")) {
//                    getAllRequestAdmin = new Service().getAllCardsInfoUkr(cards, true, false);
//                } else if (cards != null && language.equals("eng")) {
//                    getAllRequestAdmin = new Service().getAllCardsInfoEng(cards, true, false);
//                }
            }
            session.setAttribute("clients", clients);
            session.setAttribute("cards", cards);
            session.setAttribute("cardsForRequestAdmin", cardsForRequestAdmin);

            if(clients == null || cards == null || cardsForRequestAdmin == null || findCountAllCard == -1) {
                req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req, resp);
            } else if (action.equals("blockUnblockClient")) {
                req.getRequestDispatcher("adminClientStatusChange.jsp?lang=" + language).forward(req, resp);
            } else if (action.equals("blockUnblockCards")) {
                req.getRequestDispatcher("adminAllCardsStatusChange.jsp?lang=" + language).forward(req, resp);
            } else {
                req.getRequestDispatcher("adminCardsStatusChange.jsp?lang=" + language).forward(req, resp);
            }
            return req;
        }
    }

