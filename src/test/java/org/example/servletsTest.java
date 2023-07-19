package org.example;

import org.example.services.LoginClientService;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


public class servletsTest {
    @Test
    public void loginClientTest () throws ServletException, DBException, IOException {
        LoginClientService loginClientMok = mock(LoginClientService.class);

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
//        HttpSession session = mock(req.getSession());
        RequestDispatcher disp = mock(RequestDispatcher.class);
//        disp.include(req,resp);
//        disp.forward(req, resp);
//        when(req.getAttribute("ClientEMail")).thenReturn(null);
//        when(req.getAttribute("Password")).thenReturn("");
//        when(req.getAttribute("lang")).thenReturn("ua");
//        when(req.getAttribute("action")).thenReturn("login");
//        when(req.getAttribute("ClientRole")).thenReturn(Roles.USER_STRING);
        req.setAttribute("ClientEMail", null);
        req.setAttribute("Password", null);
        req.setAttribute("lang", "ua");
        req.setAttribute("ClientRole", Roles.USER_STRING);
        req.setAttribute("action", "login");
//        when(req.getRequestDispatcher("/infoMessage?lang=ua&message=error")).thenReturn(req.getRequestDispatcher("/infoMessage?lang=ua&message=error"));

        loginClientMok.loginClientChecking(req, resp);
        Assert.assertEquals("/infoMessage?lang=ua&message=error", req.getRequestURI());

    }
}
