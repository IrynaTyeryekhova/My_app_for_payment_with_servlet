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
                   - <fmt:message key="name.app.personalOffice" /><br>_____________________________________________ <br></h2>
                 <h2 name="hello"> <fmt:message key="name.app.hello" />${hello}<br> _____________________________________________ <br></h2>
                 <p><fmt:message key="name.app.action.personalOffice" /></p>

                 <form name="formLog" action=<fmt:message key="form.actionCardsMenu" /> target="_blanc" method="post">
                     <button type="submit" class="btn btn-black">  <fmt:message key="button.cards" /> </button>
                 </form>

                 <form name="formLog" action=<fmt:message key="form.actionPaymentsMenu" /> target="_blanc" method="post">
                     <button type="submit" class="btn btn-black"><fmt:message key="button.payments" /></button>
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
