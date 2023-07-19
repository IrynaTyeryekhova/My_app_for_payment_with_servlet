         <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
         <%@ page isELIgnored="false" %>
         <fmt:setLocale value="${param.lang}"/>
         <fmt:setBundle basename="resources"/>
<html lang="${param.lang}">
<head>
<head>
   <link href="stylesheet.css" rel="stylesheet">
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
   <fmt:message key="script.paymentInfoAdd" />
</head>
<body>
   <div class="sidenav">
       <div class="login-main-text">
           <h2><fmt:message key="name.app" /><br>
           - <fmt:message key="name.app.creatingPayment" /><br>_____________________________________________ <br></h2>

           <p><fmt:message key="button.preparedPayments" /></p>

           <form name="formLog" action=<fmt:message key="form.actionPaymentPrepared" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.review" /></button>
           </form>
           _____________________________________________ <br>

           <p><fmt:message key="button.backToPayments" /></p>

           <form name="formLog" action=<fmt:message key="form.actionPaymentsMenu" />  method="post">
               <button type="submit" class="btn btn-black"><fmt:message key="button.payments" /></button>
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
            <div class="login-form" style = "margin-top: 40%; margin: 0,0,0,0; padding: 0px,0px,0px,0px; margin-left: 23%; font-size: 16px; width: 430px;">
               <form action=<fmt:message key="form.actionPaymentsCreate" /> target="_blanc" method="post">

                  <div class="form-group">
                      <label><fmt:message key="formСardNumber" /></label>

                          <select style="font-size: small; margin: 0,0,0,0; width: 272px; margin-left: 10%" class="btn btn-blacktwo" name="choiceCardNumber">
                              <c:forEach var="select" items="${selectCardNumber}">
                                  <option name="choiceCardNumber" style="font-size: small; margin: 0,0,0,0" value="${select.getNumber()}"> ${select.getNumber()} </option>
                              </c:forEach>
                          </select>

                  </div>

                  <div class="form-group">
                       <label><fmt:message key="formPaymentAmount" /></label>
                       <input type="text" class="form-control" required placeholder=<fmt:message key="placeholderEnterAmount" /> name="paymentSum" minlength="1" maxlength="9">
                  </div>

                  <div class="form-group">
                       <label><fmt:message key="formPurposePayment" /></label>
                       <input type="text" class="form-control" placeholder=<fmt:message key="placeholderEnterPaymentDestination" /> name="purposePayment" maxlength="30">
                  </div>

                  <div class="form-group">
                      <label><fmt:message key="formPassword" /></label>
                      <input type="password" class="form-control"  required placeholder=<fmt:message key="placeholderPassword" /> name="cardPasswordAddPayment">
                  </div>

                  <p><fmt:message key="formRequiredFields" /></p><br>

                  <button type="submit" onclick="onChange()" class="btn btn-blacktwo"><fmt:message key="button.create" /></button>

               </form>
            </div>
         </div>
   </div>
</body>
</html>
