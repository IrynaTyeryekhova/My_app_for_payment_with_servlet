package org.example.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Service {
    public String helloMake(String name){
        if (name == null || name.length() == 0) return "!";
        else return ", " + name + "!";
    }

    public String getParameter(HttpSession session, HttpServletRequest req, String parameter){
        String param = req.getParameter(parameter);
        if(param==null && parameter.equals("lang")) { param = "ua";}
        if(param==null) { param = (String) session.getAttribute(parameter);}
        if(param==null&&(parameter.equals("ClientName")||parameter.equals("action")||parameter.equals("admin"))) { param = "";}
        return param;
    }

}
