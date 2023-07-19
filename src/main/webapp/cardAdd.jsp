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
   <fmt:message key="script.cardAdd" />
</head>
<body>
   <div class="sidenav">
       <div class="login-main-text">
           <h2><fmt:message key="name.app" /><br>
           - <fmt:message key="name.app.addingCard" /><br>_____________________________________________ <br></h2>

           <p><fmt:message key="button.backToCardsMenu" /></p>

           <form name="formLog" action=<fmt:message key="form.actionCardsMenu" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.cards" /></button>
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
   <div class="main">

         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form  action=<fmt:message key="form.actionCardAdd" /> target="_blanc" method="post">

                  <div class="form-group">
                      <label><fmt:message key="formСardNumber" /></label>
                      <input type="text" language="english" class="form-control" required placeholder=<fmt:message key="placeholderCardNumber" /> name="cardNumberAdd" maxlength="16">
                  </div>

                  <div class="form-group">
                       <label><fmt:message key="formBalance" /></label>
                       <input type="text" class="form-control" required placeholder=<fmt:message key="placeholderNewBalance" /> name="cardBalance" minlength="1" maxlength="9">
                  </div>

                  <div class="form-group">
                       <label><fmt:message key="formValidityPeriod" /></label>
                       <input type="text" class="form-control" required placeholder=<fmt:message key="placeholderValidityPeriod" /> name="cardPeriod" maxlength="10" >
                  </div>

                  <div class="form-group">
                      <label><fmt:message key="formPassword" /></label>
                      <input type="password" class="form-control"  required placeholder=<fmt:message key="placeholderPassword" /> name="cardPassword">
                  </div>

                  <div class="form-group">
                       <label><fmt:message key="formPasswordConfirm" /></label>
                       <input type="password" class="form-control"  required placeholder=<fmt:message key="placeholderPasswordConfirm" /> name="cardConfirm">
                  </div>
                  <p><fmt:message key="formRequiredFields" /></p>

                  <button type="submit" onclick="onChange()" class="btn btn-blacktwo"><fmt:message key="button.add" /></button>

               </form>
            </div>
         </div>
   </div>
</body>
</html>
