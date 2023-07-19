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
           - <fmt:message key="name.app.clientUnlockRequests" /><br>_____________________________________________ <br></h2>
           <p> <fmt:message key="name.app.action.sort" />
               <form style="font-size: xx-small; margin: 0,0,0,0" name="formLog" action=<fmt:message key="form.actionAdminCardsMenu" />  method="post">
                   <select style="font-size: small; margin: 0,0,0,0; " class="btn btn-black-option" name="selectParamSortCards">
                       <c:forEach var="sort" items="${paramSortCardsList}">
                           <c:if test="${selectParamSortCards == sort}">
                               <option style="font-size: small; margin: 0,0,0,0" value="${sort}" selected> <fmt:message key="${sort}" /> </option>
                           </c:if>
                           <c:if test="${selectParamSortCards != sort}">
                               <option style="font-size: small; margin: 0,0,0,0" value="${sort}"> <fmt:message key="${sort}" /></option>
                           </c:if>
                       </c:forEach>
                   </select>
                   <select style="font-size: small; margin: 0,0,0,0; " class="btn btn-black-option" name="selectParamSortType">
                       <c:forEach var="sort" items="${paramSortTypeList}">
                           <c:if test="${selectParamSortType == sort}">
                               <option style="font-size: small; margin: 0,0,0,0" value="${sort}" selected> <fmt:message key="${sort}" /> </option>
                           </c:if>
                           <c:if test="${selectParamSortType != sort}">
                               <option style="font-size: small; margin: 0,0,0,0" value="${sort}"> <fmt:message key="${sort}" /></option>
                           </c:if>
                       </c:forEach>
                   </select>
                   <button style="font-size: small; margin: 0,0,0,0; padding: 0px,0px,0px,0px;" type="submit" class="btn btn-black-option"><fmt:message key="button.apply" /></button>
               </form>
           </p>
           <p> <fmt:message key="name.app.action.showBy" />
               <form style="font-size: xx-small; margin: 0,0,0,0;" name="formLog" action=<fmt:message key="form.actionAdminCardsMenu" />  method="post">
                   <select style="font-size: small; margin: 0,0,0,0; " class="btn btn-black-option" name="selectCountShow">
                       <c:forEach var="sort" items="${countShowList}">
                           <c:if test="${selectCountShow == sort}">
                               <option style="font-size: small; margin: 0,0,0,0" value="${sort}" selected> ${sort} </option>
                           </c:if>
                           <c:if test="${selectCountShow != sort}">
                               <option style="font-size: small; margin: 0,0,0,0" value="${sort}"> ${sort}</option>
                           </c:if>
                       </c:forEach>
                   </select>
                   <button style="font-size: small; margin: 0,0,0,0; padding: 0px,0px,0px,0px;" type="submit" class="btn btn-black-option"><fmt:message key="button.apply" /></button>
               </form>
           </p>
           _____________________________________________ <br>

           <p><fmt:message key="button.menu" /></p>

           <form name="formLog" action=<fmt:message key="form.actionAdminCardsMenuJSP" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.menu" /></button>
           </form>

           _____________________________________________ <br>
           <p><fmt:message key="languageChangeText" /></p>

           <form name="formLog" action=<fmt:message key="languageChangeLink" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="languageChangeButton" /></button>
           </form>
       </div>
   </div>
   <div class="main">
       <div >
           <form name="formLog" action=<fmt:message key="form.actionExit" />  method="post">
               <button style = "margin-left: 85%; margin-top: 1%;"type="submit" class="btn btn-blacktwo"><fmt:message key="button.logOut" /></button>
           </form>
           <form name="formLog" action=<fmt:message key="form.actionAdminCardsMenu" />  method="post">
               <button style = " margin: 0,0,0,0; padding: 0px,0px,0px,0px; margin-left: 23%; margin-top: 12%; position: fixed;  z-index: 1; font-weight: 100; padding: 6px" type="submit" class="btn btn-blacktwo" name = "previousPage" value = "1"><fmt:message key="button.back" /></button>
               <button style = "background-color: #000 !important; color: #FFF; width: 30px; margin: 0,0,0,0; padding: 0px,0px,0px,0px; margin-left: 30.55%; margin-top: 12%; position: fixed;  z-index: 1; font-weight: 100; padding: 5px">${numberPage}</button>
               <button style = " margin: 0,0,0,0; padding: 0px,0px,0px,0px; margin-left: 33%; margin-top: 12%; position: fixed;  z-index: 1; font-weight: 100; padding: 6px" type="submit" class="btn btn-blacktwo" name = "nextPage" value = "1" ><fmt:message key="button.next" /></button>
           </form>
       </div>

       <div>
           <form name="formLog" action=<fmt:message key="form.actionCardStatusChangeAdminRequest" />  method="post">
               <table class= "tablePayments" style="font-family: Arial, sans-serif; width: 42%;text-align: center; margin-left: 10%; margin-top: 16%; position: fixed;  z-index: 1; font-weight: 100; padding: 60px" border = "3">
                   <tr>
                       <th> <fmt:message key="card.info.numberCardForTable" /> </th>
                       <th> <fmt:message key="card.info.balanceForTable" /> </th>
                       <th> <fmt:message key="card.info.validityPeriodForTable" /> </th>
                   </tr>

                   <c:forEach var="sort" items="${cardsForRequestAdmin}">
                       <tr>
                           <td> ${sort.getNumber()} </td>
                           <td> ${sort.getBalance()} </td>
                           <td> ${sort.getValidityPeriod()} </td>
                           <td> <button style="width: 130px;" type="submit" class="btn btn-blacktwo" name = "cardStatusSend" value = "${sort.getNumber()}"><fmt:message key="button.unblock" /></button></td>
                       </tr>
                   </c:forEach>
               </table>
           </form>
       </div>
   </div>
  </body>
</html>
