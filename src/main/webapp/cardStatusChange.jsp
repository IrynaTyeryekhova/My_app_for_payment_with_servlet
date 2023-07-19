         <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
         <%@ page isELIgnored="false" %>
         <fmt:setLocale value="${param.lang}" />
         <fmt:setBundle basename="resources"/>
<html lang="${param.lang}">
<head>
   <link href="stylesheet.css" rel="stylesheet">
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
   <fmt:message key="script.statusChange" />
</head>
  <body>
   <div class="sidenav">
       <div class="login-main-text">
           <h2><fmt:message key="name.app" /><br>
           - <fmt:message key="name.app.statusChange" />
           <br>_____________________________________________ <br></h2>
           <p><fmt:message key="button.backToCardTransaction" /></p>

           <form name="formLog" action=<fmt:message key="form.actionCardsInfo" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.cards" /></button>
           </form>

           _____________________________________________ <br>
           <p><fmt:message key="languageChangeText" /></p>

           <form name="formLog" action=<fmt:message key="languageChangeLink" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="languageChangeButton" /></button>
           </form>
       </div>
   </div>
   <div class="main">
       <form name="formLog" action=<fmt:message key="form.actionExit" />  method="post">
           <button style = "margin-left: 85%; margin-top: 1%;"type="submit" class="btn btn-blacktwo"><fmt:message key="button.logOut" /></button>
       </form>
       <div class="col-md-6 col-sm-12">
           <div class="login-form" style="font-family: Arial, sans-serif; width: 30%; margin-left: 5%; margin-top: 7%; position: fixed;  z-index: 1; font-weight: 100; padding: 60px">
               <form action=<fmt:message key="form.actionCardStatusChange" /> target="_blanc" method="post">
                   <p><fmt:message key="${StatusChangeMessage}" /></p>
                   <div class="form-group">
                       <label><fmt:message key="formPassword" /></label>
                       <input type="password" class="form-control" required placeholder=<fmt:message key="placeholderPassword" /> name="passwordCard">
                   </div>
                   <p><fmt:message key="formRequiredFields" /></p>
                   <button style = " width: 130px" type="submit" onclick="onChange()" class="btn btn-blacktwo"><fmt:message key="${ButtonChangeStatus}" /></button>
               </form>
           </div>
       </div>
   </div>
  </body>
</html>
