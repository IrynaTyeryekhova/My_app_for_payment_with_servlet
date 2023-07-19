package org.example.servlets;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.services.CardBalanceService;
import org.example.services.DoGetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cardBalanceChange")
public class CardBalanceChange extends HttpServlet {
    public static final Logger LOG=Logger.getLogger(CardBalanceChange.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {

        try {
            resp = new CardBalanceService().cardBalanceMake(req, resp);
        } catch (ServletException e) {
            LOG.info("CardBalanceChange. ServletException");
        } catch (IOException e) {
            LOG.info("CardBalanceChange. IOException");
        } catch (DBException e) {
            LOG.info("CardBalanceChange. DBException");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req = new DoGetService().doGet(req, resp);
        } catch (IOException e) {
            LOG.info("CardBalanceChange. IOException");
        } catch (ServletException e) {
            LOG.info("CardBalanceChange. ServletException");
        }
    }
}




