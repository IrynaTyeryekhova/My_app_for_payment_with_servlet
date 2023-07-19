         <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
         <%@ page isELIgnored="false" %>
         <fmt:setLocale value="${param.lang}"/>
         <fmt:setBundle basename="resources"/>
<html lang="${param.lang}">
<head>
   <link href="stylesheet.css" rel="stylesheet">
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
   <div class="sidenav">
       <div class="login-main-text">
           <h2><fmt:message key="name.app" /><br>
           - <fmt:message key="name.app.cardsMenu" /><br>_____________________________________________ <br></h2>
           <p> <fmt:message key="name.app.action.sort" />
           <form style="font-size: xx-small; margin: 0,0,0,0" name="formLog" action=<fmt:message key="form.actionCardsMenu" />  method="post">
               <select class="btn btn-black-option" name="actualParamSortCardMenu">
                   <c:forEach var="sort" items="${paramSortListCardMenu}">
                       <c:if test="${actualParamSortCardMenu == sort}">
                          <option style="font-size: small; margin: 0,0,0,0" value="${sort}" selected> <fmt:message key="${sort}" /></option>
                       </c:if>
                       <c:if test="${actualParamSortCardMenu != sort}">
                          <option style="font-size: small; margin: 0,0,0,0" value="${sort}"> <fmt:message key="${sort}" /></option>
                       </c:if>
                   </c:forEach>
               </select>
               <button style="font-size: small; margin: 0,0,0,0; padding: 0px,0px,0px,0px;" type="submit" class="btn btn-black-option"><fmt:message key="button.apply" /></button>
           </form></p>

           <c:forEach var="cardAccount" items="${cardAccountsForCardMenu}">
               <p> <fmt:message key="card.info.number" /> ${cardAccount.getNumber()}</p>
               <form name="formLog" action=<fmt:message key="form.actionCardsInfo" /> method="post" value="${cardAccount.getNumber()}">
                   <input type="hidden" name="cardNumber" value="${cardAccount.getNumber()}"/>
                   <button type="submit" class="btn btn-black" > ${cardAccount.getBalance()} </button>
                   <param name="formLog" value="${cardAccount.getNumber()}">
               </form>
           </c:forEach>

           <p> <fmt:message key="button.add.card" /> </p>
           <form name="formLog" action=<fmt:message key="form.actionCardAdd.jsp" /> method="post">
               <button type="submit" class="btn btn-black"> <fmt:message key="button.add" /> </button>
           </form>
           _____________________________________________ <br>
           <p><fmt:message key="button.backToMenu" /></p>
           <form name="formLog" action=<fmt:message key="form.actionRegister.WithOutAction.lang" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.menu" /></button>
           </form>
           _____________________________________________ <br>
           <p><fmt:message key="button.exit" /></p>

           <form name="formLog" action=<fmt:message key="form.actionExit" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.logOut" /></button>
           </form>
           _____________________________________________ <br>
           <p><fmt:message key="languageChangeText" /></p>

           <form name="formLog" action=<fmt:message key="languageChangeLink" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="languageChangeButton" /></button>
           </form>
       </div>
   </div>
  </body>
</html>
