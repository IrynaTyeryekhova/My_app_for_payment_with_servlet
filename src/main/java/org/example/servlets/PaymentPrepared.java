package org.example.servlets;

import org.example.DBException;
import org.example.services.PaymentPreparedService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/paymentPrepared")
public class PaymentPrepared extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
                req = new PaymentPreparedService().paymentPreparedMake(req, resp);
            } catch (DBException e) {
                throw new RuntimeException(e);
            }
        }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
 }

