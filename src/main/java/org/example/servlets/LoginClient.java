package org.example.servlets;

import org.apache.log4j.Logger;
import org.example.DBException;
import org.example.services.LoginClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/login")
    public class LoginClient extends HttpServlet {
        public static final Logger LOG=Logger.getLogger(LoginClientService.class.getName());

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp)  {
            try {
                resp = new LoginClientService().loginClientChecking(req, resp);
            } catch (DBException e) {
                LOG.info("Login client. DBException");
            } catch (ServletException e) {
                LOG.info("Login client. ServletException");
            } catch (IOException e) {
                LOG.info("Login client. IOException");
            }
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
            try {
                req = new LoginClientService().loginDoGet(req, resp);
            } catch (ServletException e) {
                LOG.info("Login client. ServletException");
            } catch (IOException e) {
                LOG.info("Login client. IOException");
            }
        }
    }