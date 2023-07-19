package org.example.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class AccessFilter implements Filter{

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpSession session = httpServletRequest.getSession();
            boolean loggedIn = session != null && session.getAttribute("ClientEMail") != null;

            String stylesheetURI = httpServletRequest.getContextPath() + "/stylesheet.css";
            String scriptLogENGURI = httpServletRequest.getContextPath() + "/scriptLogENG.js";
            String scriptLogURI = httpServletRequest.getContextPath() + "/scriptLog.js";
            String startURI = httpServletRequest.getContextPath() + "/";
            String indexURI = httpServletRequest.getContextPath() + "/index.jsp";
            String loginIndexURI = httpServletRequest.getContextPath() + "/indexLogin.jsp";
            String loginURI = httpServletRequest.getContextPath() + "/login";
            String registerURI = httpServletRequest.getContextPath() + "/register";
            String registerIndexURI = httpServletRequest.getContextPath() + "/indexRegister.jsp";
            String infoLoginMessageURI = httpServletRequest.getContextPath() + "/infoLoginMessage";

            boolean stylesheetRequest = httpServletRequest.getRequestURI().equals(stylesheetURI);
            boolean scriptLogENGRequest = httpServletRequest.getRequestURI().equals(scriptLogENGURI);
            boolean scriptLogRequest = httpServletRequest.getRequestURI().equals(scriptLogURI);
            boolean startRequest = httpServletRequest.getRequestURI().equals(startURI);
            boolean indexRequest = httpServletRequest.getRequestURI().equals(indexURI);
            boolean loginIndexRequest = httpServletRequest.getRequestURI().equals(loginIndexURI);
            boolean loginRequest = httpServletRequest.getRequestURI().equals(loginURI);
            boolean registerRequest = httpServletRequest.getRequestURI().equals(registerURI);
            boolean registerIndexRequest = httpServletRequest.getRequestURI().equals(registerIndexURI);
            boolean infoLoginMessageRequest = httpServletRequest.getRequestURI().equals(infoLoginMessageURI);

            if (loggedIn || loginRequest || registerRequest || indexRequest ||
                    loginIndexRequest || startRequest || infoLoginMessageRequest ||
                    registerIndexRequest || stylesheetRequest ||
                    scriptLogENGRequest || scriptLogRequest) {
                next.doFilter(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        public void init(FilterConfig filterConfig) {}

        public void destroy() {}
    }


