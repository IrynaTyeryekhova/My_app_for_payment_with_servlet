package org.example.servlets;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.services.CardInfoService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cardsInfo")
public class CardInfo extends HttpServlet {
    public static final Logger LOG=Logger.getLogger(CardInfo.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            req = new CardInfoService().cardInfoMake(req, resp);
        } catch (ServletException e) {
            LOG.info("CardInfo. ServletException");
        } catch (IOException e) {
            LOG.info("CardInfo. IOException e");
        } catch (DBException e) {
            LOG.info("CardInfo. DBException");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        doPost(req, resp);
    }
}