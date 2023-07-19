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

              <h2><fmt:message key="name.appErr" /><br> _____________________________________________ <br></h2>
              <fmt:message key="${infoMessage}" />

              <form name="formLog" action=<fmt:message key="login.page" /> target="_blanc" method="post">
                   <button type="submit" class="btn btn-black"> <fmt:message key="button.login" /> </button>
              </form>

              <form name="formLog" action=<fmt:message key="register.page" /> target="_blanc" method="post">
                   <button type="submit" class="btn btn-black"><fmt:message key="button.register" /></button>
              </form>

              <br> _____________________________________________ <br>
              <p><fmt:message key="languageChangeText" /></p>

              <form name="formLog" action=<fmt:message key="languageChangeLink.infoLoginMessage" />  method="post">
                   <button type="submit" class="btn btn-black"><fmt:message key="languageChangeButton" /></button>
              </form>

         </div>
    </div>
</body>
</html>
