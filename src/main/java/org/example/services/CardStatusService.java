package org.example.services;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.dbServices.DBCardService;
import org.example.dbServices.DBClientService;
import org.example.Statuses;
import org.example.entities.CardAccount;
import org.example.entities.Client;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

public class CardStatusService {
    public static final Logger LOG=Logger.getLogger(CardStatusService.class.getName());

    public HttpServletResponse cardStatusMake(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, DBException {
        LOG.info("CardStatusService is starting");
        HttpSession session = req.getSession();
        Service service = new Service();
        String language = service.getParameter(session, req,"lang");
        String change = service.getParameter(session, req,"change");
        String adminChange = service.getParameter(session, req,"admin");
        String cardStatusSend = service.getParameter(session, req, "cardStatusSend");
        String cardEmailChangeStatus = service.getParameter(session, req, "cardEmailChangeStatus");

        if (adminChange.equals("true") && change.equals("request")) statusChangeRequestAdmin(cardStatusSend, language, req, resp);
        else if (adminChange.equals("true") && change.equals("all")) statusChangeAdmin(cardStatusSend, language, req, resp);
        else if (adminChange.equals("true") && change.equals("client")) clientChangeAdmin(cardEmailChangeStatus, language, req, resp);
        else {
            String actualStatus = service.getParameter(session, req, "cardInfoStatus");
            statusChangeClient(actualStatus, session, language, req, resp);
            if (actualStatus.equals("unblock")) resp.sendRedirect("/cardStatusChange?lang=" + language + "&message=status");
            else resp.sendRedirect("/cardStatusChange?lang=" + language + "&message=sendRequestAdmin");
        } return resp;
    }

    private HttpServletRequest statusChangeRequestAdmin(String cardNumber, String language, HttpServletRequest req, HttpServletResponse resp) throws DBException, ServletException, IOException {
        DBCardService cardService = DBCardService.getInstance();
        CardAccount cardAccount = cardService.getCardInfo(cardNumber);

        if (cardAccount == null) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req,resp);
        else if ((cardAccount.getValidityPeriod()).compareTo(LocalDate.now().toString()) < 0) {
            req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=sendRequestAdminErrValidityPeriod&adminPage=true").forward(req, resp);
        } else {
            int updateResult = cardService.updateCardStatus(cardNumber, Statuses.UNBLOCK, "false");
            int sendRequest = cardService.updateRequestAdmin(cardAccount.getId(), Statuses.DONE);

            if (updateResult == 1 && sendRequest == 1) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=status&adminPage=true").forward(req, resp);
            else req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=sendRequestAdminErr&adminPage=true").forward(req, resp);
        }
        return req;
    }

    private HttpServletRequest statusChangeAdmin(String cardNumber, String language, HttpServletRequest req, HttpServletResponse resp) throws DBException, ServletException, IOException {
        DBCardService cardService = DBCardService.getInstance();
        CardAccount cardAccount = cardService.getCardInfo(cardNumber);
        String status = "";
        if (cardAccount != null) { status = cardAccount.getStatus();}

        if(cardAccount == null) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req,resp);
        else if ((cardAccount.getValidityPeriod()).compareTo(LocalDate.now().toString()) < 0 && status.equals("block")) {
            req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=sendRequestAdminErrValidityPeriod&adminPage=true").forward(req, resp);
        } else {
            int updateResult = 0;

            if(status.equals("block")) updateResult = cardService.updateCardStatus(cardNumber, Statuses.UNBLOCK, "false");
            else if(status.equals("unblock")) updateResult = cardService.updateCardStatus(cardNumber, Statuses.BLOCK, "false");

            if (updateResult == 1) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=status&adminPage=true").forward(req, resp);
            else req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=sendRequestAdminErr&adminPage=true").forward(req, resp);
        }
       return req;
    }
    private HttpServletRequest clientChangeAdmin(String email, String language, HttpServletRequest req, HttpServletResponse resp) throws DBException, ServletException, IOException {
        DBClientService clientService = DBClientService.getInstance();
        Client client = clientService.getClientInfo(email);

        int updateResult = 0;
        if(client != null) {
            String status = client.getStatus();

            if (status.equals(Statuses.BLOCK_STRING)) updateResult = clientService.updateClientStatus(email, Statuses.UNBLOCK);
            else if (status.equals(Statuses.UNBLOCK_STRING)) updateResult = clientService.updateClientStatus(email, Statuses.BLOCK);

            if (updateResult == 1) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=status&adminPage=true").forward(req, resp);
        }
        if(client == null || updateResult == 0)  req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=sendRequestAdminErr&adminPage=true").forward(req, resp);
        return req;
    }
    private HttpServletRequest statusChangeClient(String actualStatus, HttpSession session, String language, HttpServletRequest req, HttpServletResponse resp) throws DBException, ServletException, IOException {
        Service service = new Service();
        String cardNumber = service.getParameter(session, req, "cardNumber");
        String password = service.getParameter(session, req, "passwordCard");
        int updateResult;
        DBCardService cardService = DBCardService.getInstance();

        if (actualStatus.equals("unblock")) {
            updateResult = cardService.updateCardStatus(cardNumber, Statuses.BLOCK, password);
            if (updateResult == 0) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=updateCardStatusErr").forward(req, resp);
            else if (updateResult == 2) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=updateCardStatusErrPassword").forward(req, resp);
        } else {
            int getRequestAdmin = cardService.getRequestAdmin(cardNumber, Statuses.NEW);
            if (getRequestAdmin == 0) {
                updateResult = cardService.insertRequestAdmin(cardNumber, Statuses.BLOCK, password);
                if (updateResult == 0) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=sendRequestAdminErr").forward(req, resp);
                else if (updateResult == 2) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=sendRequestAdminErrPassword").forward(req, resp);
            } else if (getRequestAdmin == -1) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=error").forward(req, resp);
            else {
                if (cardService.equalsCardPassword(cardNumber, password)) req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=duplicateSendRequestAdminErr").forward(req, resp);
                else req.getRequestDispatcher("/infoMessage?lang=" + language + "&message=sendRequestAdminErrPassword").forward(req, resp);
            }
        } return req;
    }
}



