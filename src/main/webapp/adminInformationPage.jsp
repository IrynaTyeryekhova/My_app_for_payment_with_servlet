         <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
         <%@ page isELIgnored="false" %>
         <fmt:setLocale value="${sessionScope.lang}"/>
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
           - <fmt:message key="${infoMessageMenu}" /><br>_____________________________________________ <br></h2>

           <p><fmt:message key="button.requestsToUnlockCards" /></p>
           <form name="formLog" action=<fmt:message key="form.actionAdminCardsMenu" /> target="_blanc" method="post">
               <button type="submit" class="btn btn-black">  <fmt:message key="button.review" /> </button>
           </form>

           <p><fmt:message key="button.blockingUnblockingOfCards" /></p>
           <form name="formLog" action=<fmt:message key="form.actionAdminCardsMenu.blockUnblockCards" /> target="_blanc" method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.goTo" /></button>
           </form>

           <p><fmt:message key="button.blockingUnblockingClients" /></p>
           <form name="formLog" action=<fmt:message key="form.actionAdminCardsMenu.blockUnblockClients" /> target="_blanc" method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.goTo" /></button>
           </form>
       </div>
   </div>
   <div class="main">
       <form name="formLog" action=<fmt:message key="form.actionExit" />  method="post">
           <button style = "margin-left: 85%; margin-top: 1%;"type="submit" class="btn btn-blacktwo"><fmt:message key="button.logOut" /></button>
       </form>
       <h3 style="font-family: Arial, sans-serif; width: 30%;text-align: center; margin-left: 10%; margin-top: 12%; position: fixed;  z-index: 1; font-weight: 100; padding: 60px"><fmt:message key="${infoMessage}" /><br>
       </h3>
   </div>
  </body>
</html>
