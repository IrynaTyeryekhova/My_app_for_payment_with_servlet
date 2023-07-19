package org.example.services;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

public class PaginationService {
    public static final Logger LOG=Logger.getLogger(PaginationService.class.getName());
    public void paginationParameterSortMake(HttpServletRequest req, String paramSortListName, String parametrSortName, String... values) {
        LOG.info("PaginationService is starting");
        HttpSession session = req.getSession();
        Service service = new Service();
        String parametrSort =  service.getParameter(session, req, parametrSortName);
        String parametrSortType =  service.getParameter(session, req, "selectParamSortType");

        if(parametrSort==null) {parametrSort = values[0];}
        if(parametrSortType==null) {parametrSortType = "ASC";}

        session.setAttribute(paramSortListName, values);
        session.setAttribute("paramSortTypeList", Arrays.asList("ASC", "DESC"));
        session.setAttribute(parametrSortName, parametrSort);
        session.setAttribute("selectParamSortType", parametrSortType);
       }

    public void paginationMake(HttpServletRequest req, int paymentCount) {
        HttpSession session = req.getSession();
        String nextPage =  req.getParameter("nextPage");
        String previousPage =  req.getParameter("previousPage");

        Integer numberPage = 1;
        Integer limit = 2;

        String page = req.getParameter("numberPage");
        String limitValue = req.getParameter("selectCountShow");

        if(limitValue==null && session.getAttribute("selectCountShow") != null) limitValue = String.valueOf(session.getAttribute("selectCountShow"));
        if(limitValue!=null) limit = Integer.valueOf(limitValue);
        if(page==null && session.getAttribute("numberPage") != null) page = String.valueOf(session.getAttribute("numberPage"));
        if(page!=null) numberPage = Integer.valueOf(page);
        if(paymentCount%limit!=0){
            if((paymentCount/limit)+1<numberPage) numberPage = 1;
        }
        else {
            if((paymentCount/limit)<numberPage) numberPage = 1;
        }

        if(nextPage != null && Integer.valueOf(nextPage)==1 && ((numberPage)*limit < paymentCount)) {++numberPage;}
        if(previousPage != null && Integer.valueOf(previousPage)==1 && numberPage-1 > 0) {--numberPage;}

        session.setAttribute("numberPage", numberPage);
        session.setAttribute("selectCountShow", limit);
        session.setAttribute("countShowList", Arrays.asList("2", "3", "5"));
    }
}
