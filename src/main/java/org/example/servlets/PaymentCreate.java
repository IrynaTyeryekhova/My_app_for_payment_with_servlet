package org.example.servlets;

import org.example.DBException;
import org.example.services.DoGetService;
import org.example.services.PaymentCreateService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/paymentCreate")
public class PaymentCreate extends HttpServlet{

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
                resp = new PaymentCreateService().paymentAddMake(req, resp);
            } catch (DBException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req = new DoGetService().doGet(req, resp);
            }
}

