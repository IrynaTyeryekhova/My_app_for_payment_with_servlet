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
           - <fmt:message key="name.app.cardTransactions" />
           <br>_____________________________________________ <br></h2>
           <p> <fmt:message key="name.app.action.sort" />
               <form style="font-size: xx-small; margin: 0,0,0,0" name="formLog" action=<fmt:message key="form.actionCardsInfo" />  method="post">
                   <select style="font-size: small; margin: 0,0,0,0; " class="btn btn-black-option" name="selectParamSortPaymentForCard">
                       <c:forEach var="sort" items="${paramSortPaymentsForCardList}">
                           <c:if test="${selectParamSortPaymentForCard == sort}">
                               <option style="font-size: small; margin: 0,0,0,0" value="${sort}" selected> <fmt:message key="${sort}" /> </option>
                           </c:if>
                           <c:if test="${selectParamSortPaymentForCard != sort}">
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
               <form style="font-size: xx-small; margin: 0,0,0,0;" name="formLog" action=<fmt:message key="form.actionCardsInfo" />  method="post">
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
           <p><fmt:message key="button.balanceChange" /></p>

           <form name="formLog" action=<fmt:message key="form.actionCardBalanceChangeInfo" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.change" /></button>
           </form>
           _____________________________________________ <br>
           <p><fmt:message key="button.statusChange" /></p>

           <form name="formLog" action=<fmt:message key="form.actionCardStatusChangeInfo" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.change" /></button>
           </form>
           _____________________________________________ <br>
           <p><fmt:message key="button.backToCardsMenu" /></p>

           <form name="formLog" action=<fmt:message key="form.actionCardsMenu" />  method="post">
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

       <form style=" margin: 0,0,0,0; padding: 0px,0px,0px,0px; margin-left: 17%; margin-top: 1%; position: fixed;  z-index: 1; font-weight: 900px; padding: 6px"  method="post">
           <p><fmt:message key="card.info.number" /> ${cardInfoCardNumber}</br>
               <fmt:message key="card.info.validityPeriod" /> ${cardInfoValidityPeriod} </br>
               <fmt:message key="card.info.balance" /> ${cardInfoBalance} </br>
               <fmt:message key="card.info.status" /> <fmt:message key="${cardInfoStatus}" />
           </p>
       </form>
       <form name="formLog" action=<fmt:message key="form.actionCardsInfo" />  method="post">
           <button style = " margin: 0,0,0,0; padding: 0px,0px,0px,0px; margin-left: 17%; margin-top: 11%; position: fixed;  z-index: 1; font-weight: 100; padding: 6px" type="submit" class="btn btn-blacktwo" name = "previousPage" value = "1"><fmt:message key="button.back" /></button>
           <button style = "background-color: #000 !important; color: #FFF; width: 30px; margin: 0,0,0,0; padding: 0px,0px,0px,0px; margin-left: 24.55%; margin-top: 11%; position: fixed;  z-index: 1; font-weight: 100; padding: 5px">${numberPage}</button>
           <button style = " margin: 0,0,0,0; padding: 0px,0px,0px,0px; margin-left: 27%; margin-top: 11%; position: fixed;  z-index: 1; font-weight: 100; padding: 6px" type="submit" class="btn btn-blacktwo" name = "nextPage" value = "1" ><fmt:message key="button.next" /></button>
       </form>
       <table class= "tablePayments" style="font-family: Arial, sans-serif; width: 30%;text-align: center; margin-left: 10%; margin-top: 15%; position: fixed;  z-index: 1; font-weight: 100; padding: 60px" border = "3">
           <tr>
               <th> <fmt:message key="payment.info.number" /> </th>
               <th> <fmt:message key="payment.info.date" /> </th>
               <th> <fmt:message key="payment.info.sum" /> </th>
               <th> <fmt:message key="payment.info.status" /> </th>
               <th> <fmt:message key="payment.info.purpose" /> </th>
           </tr>

           <c:forEach var="sort" items="${paymentsForCard}">
               <tr>
                   <td> ${sort.getId()} </td>
                   <td> ${sort.getDate()} </td>
                   <td> ${sort.getSum()} </td>
                   <td> <fmt:message key="${sort.getStatus()}" /> </td>
                   <td> ${sort.getPurposePayment()} </td>
               </tr>
           </c:forEach>
       </table>
   </div>
  </body>
</html>
