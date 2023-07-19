package org.example.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AccessRoleFilter implements Filter{

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpSession session = httpServletRequest.getSession();
            String clientRole = (String) session.getAttribute("ClientRole");
            String clientEMail = (String) session.getAttribute("ClientEMail");

            String language = request.getParameter("lang");
            if(language == null) {language = "ukr";}
            boolean loggedIn = session != null && clientRole != null && language !=null && clientEMail != null;

            String adminCardsMenuURI = httpServletRequest.getContextPath() + "/adminCardsMenu";
            String adminAllCardsStatusChangeURI = httpServletRequest.getContextPath() + "/adminAllCardsStatusChange.jsp";
            String adminCardsStatusChangeURI = httpServletRequest.getContextPath() + "/adminCardsStatusChange.jsp";
            String adminClientStatusChangeURI = httpServletRequest.getContextPath() + "/adminClientStatusChange.jsp";
            String adminInformationPageURI = httpServletRequest.getContextPath() + "/adminInformationPage.jsp";
            String adminCardsMenuGSPURI = httpServletRequest.getContextPath() + "/adminCardsMenu.jsp";
            String exitURI = httpServletRequest.getContextPath() + "/exit";
            String startURI = httpServletRequest.getContextPath() + "/";
            String cardStatusChangeURI = httpServletRequest.getContextPath() + "/cardStatusChange";
            String indexURI = httpServletRequest.getContextPath() + "/index.jsp";
            String loginIndexURI = httpServletRequest.getContextPath() + "/indexLogin.jsp";
            String loginURI = httpServletRequest.getContextPath() + "/login";
            String registerURI = httpServletRequest.getContextPath() + "/register";
            String registerIndexURI = httpServletRequest.getContextPath() + "/indexRegister.jsp";
            String infoLoginMessageURI = httpServletRequest.getContextPath() + "/infoLoginMessage";

            boolean adminCardsMenuRequest = httpServletRequest.getRequestURI().equals(adminCardsMenuURI);
            boolean adminAllCardsStatusChangeRequest = httpServletRequest.getRequestURI().equals(adminAllCardsStatusChangeURI);
            boolean adminCardsStatusChangeRequest = httpServletRequest.getRequestURI().equals(adminCardsStatusChangeURI);
            boolean adminClientStatusChangeRequest = httpServletRequest.getRequestURI().equals(adminClientStatusChangeURI);
            boolean adminInformationPageRequest = httpServletRequest.getRequestURI().equals(adminInformationPageURI);
            boolean adminCardsMenuGSPRequest = httpServletRequest.getRequestURI().equals(adminCardsMenuGSPURI);
            boolean exitRequest = httpServletRequest.getRequestURI().equals(exitURI);
            boolean startRequest = httpServletRequest.getRequestURI().equals(startURI);
            boolean cardStatusChangeRequest = httpServletRequest.getRequestURI().equals(cardStatusChangeURI);
            boolean indexRequest = httpServletRequest.getRequestURI().equals(indexURI);
            boolean loginIndexRequest = httpServletRequest.getRequestURI().equals(loginIndexURI);
            boolean loginRequest = httpServletRequest.getRequestURI().equals(loginURI);
            boolean registerRequest = httpServletRequest.getRequestURI().equals(registerURI);
            boolean registerIndexRequest = httpServletRequest.getRequestURI().equals(registerIndexURI);
            boolean infoLoginMessageRequest = httpServletRequest.getRequestURI().equals(infoLoginMessageURI);

            if(exitRequest || cardStatusChangeRequest || startRequest || indexRequest || loginIndexRequest
                || loginRequest || registerRequest || registerIndexRequest || infoLoginMessageRequest) next.doFilter(request, response);
            else if(loggedIn && (adminCardsMenuRequest || adminCardsMenuGSPRequest
                                 || adminAllCardsStatusChangeRequest || adminCardsStatusChangeRequest
                                 || adminClientStatusChangeRequest || adminInformationPageRequest)) {
                if(clientRole.equals("user") && (language.equals("ukr") || language.equals("ua"))) request.getRequestDispatcher("/register?lang=ukr").forward(request,response);
                else if(clientRole.equals("user") && (language.equals("eng") || language.equals("en"))) request.getRequestDispatcher("/register?lang=eng").forward(request,response);
                else next.doFilter(request, response);
            } else if (loggedIn) {
                if (clientRole.equals("admin") && (language.equals("ukr") || language.equals("ua") || language.equals(""))) request.getRequestDispatcher("/adminCardsMenu.jsp?lang=ua").forward(request, response);
                else if (clientRole.equals("admin") && (language.equals("eng") || language.equals("en") || language.equals(""))) request.getRequestDispatcher("/adminCardsMenu.jsp?lang=en").forward(request, response);
                else next.doFilter(request, response);
            }
            else {
                request.setAttribute("lang", language);
                next.doFilter(request, response);
            }
        }

        public void init(FilterConfig filterConfig) {}

        public void destroy() {}
    }
