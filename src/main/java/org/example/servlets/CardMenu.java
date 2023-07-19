package org.example.servlets;

import org.apache.log4j.Logger;
import org.example.services.CardMenuService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cardsMenu")
public class CardMenu extends HttpServlet {
    public static final Logger LOG=Logger.getLogger(CardMenu.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req = new CardMenuService().cardMenuMake(req, resp);
        } catch (ServletException e) {
            LOG.info("CardMenu. ServletException");
        } catch (IOException e) {
            LOG.info("CardMenu. IOException");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
       doPost(req, resp);
    }
}


