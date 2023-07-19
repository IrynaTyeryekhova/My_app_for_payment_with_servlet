package org.example.servlets;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.services.LoginClientService;
import org.example.services.RegisterClientService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/register")
public class RegisterClient extends HttpServlet {
    public static final Logger LOG=Logger.getLogger(RegisterClient.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp = new RegisterClientService().registerClientMake(req, resp);
        } catch (DBException e) {
            LOG.info("Client registration. DBException");
        } catch (ServletException e) {
            LOG.info("Client registration. ServletException");
        } catch (IOException e) {
            LOG.info("Client registration. IOException");
        } catch (SQLException e) {
            LOG.info("Client registration. SQLException");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req = new RegisterClientService().registerDoGet(req, resp);
        } catch (ServletException e) {
            LOG.info("Client registration. ServletException");
        } catch (IOException e) {
            LOG.info("Client registration. IOException");
        }
    }
}

