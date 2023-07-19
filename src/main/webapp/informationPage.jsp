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
           - <fmt:message key="${infoMessageMenu}" /><br>_____________________________________________ <br></h2>

           <p><fmt:message key="button.backToCardsMenu" /></p>

           <form name="formLog" action=<fmt:message key="form.actionCardsMenu" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.cards" /></button>
           </form>
           _____________________________________________ <br>
           <p><fmt:message key="button.backToPayments" /></p>

           <form name="formLog" action=<fmt:message key="form.actionPaymentsMenu" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.payments" /></button>
           </form>

       </div>
   </div>
   <div class="main">
       <form name="formLog" action=<fmt:message key="form.actionExit" />  method="post">
           <button style = "margin-left: 85%; margin-top: 1%;"type="submit" class="btn btn-blacktwo"><fmt:message key="button.logOut" /></button>
       </form>
       <h3 style="font-family: Arial, sans-serif; width: 30%;text-align: center; margin-left: 10%; margin-top: 11%; position: fixed;  z-index: 1; font-weight: 100; padding: 60px"><fmt:message key="${infoMessage}" /><br>
       </h3>
   </div>
</body>
</html>
