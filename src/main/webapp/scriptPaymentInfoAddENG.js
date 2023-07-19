 function  onChange(){
                         const paymentSum = document.querySelector('input[name=paymentSum]');
                         const password = document.querySelector('input[name=cardPasswordAddPayment]');

                         var emptyField = '';

                         if (paymentSum.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                            paymentSum.setCustomValidity('');}
                         else if (paymentSum.value.match(/^[0-9]+$/)){
                            paymentSum.setCustomValidity('The payment amount must contain 2 digits after the dot');}
                         else if (paymentSum.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                            paymentSum.setCustomValidity('The payment amount must contain 2 digits after the dot');}
                         else if (paymentSum.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                            paymentSum.setCustomValidity('The payment amount must contain 2 digits after the dot');}
                         else if (paymentSum.value === emptyField) {
                            paymentSum.setCustomValidity('Required field');}
                         else {
                            paymentSum.setCustomValidity('The payment amount must contain only numbers');}

                         if (password.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                            password.setCustomValidity('');}
                         else if (password.value === emptyField) {
                            password.setCustomValidity('Required field');}
                         else if (password.value.length<6){
                            password.setCustomValidity('The password is too short. Enter 6 to 15 characters.');}
                         else if (password.value.length>15){
                            password.setCustomValidity('The password is too long. Enter 6 to 15 characters.');}
                         else {
                            password.setCustomValidity('Password is invalid. The password must contain only Latin letters or numbers.');
                            }

                         paymentSum.addEventListener('input', function (event) {
                            if (paymentSum.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                               paymentSum.setCustomValidity('');}
                            else if (paymentSum.value.match(/^[0-9]+$/)){
                               paymentSum.setCustomValidity('The payment amount must contain 2 digits after the dot');}
                            else if (paymentSum.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                               paymentSum.setCustomValidity('The payment amount must contain 2 digits after the dot');}
                            else if (paymentSum.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                               paymentSum.setCustomValidity('The payment amount must contain 2 digits after the dot');}
                            else if (paymentSum.value === emptyField) {
                               paymentSum.setCustomValidity('Required field');}
                            else {
                               paymentSum.setCustomValidity('The payment amount must contain only numbers');}

                            password.addEventListener('input', function (event) {
                               if (password.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                                  password.setCustomValidity('');}
                               else if (password.value === emptyField) {
                                  password.setCustomValidity('Required field');}
                               else if (password.value.length<6){
                                  password.setCustomValidity('The password is too short. Enter 6 to 15 characters.');}
                               else if (password.value.length>15){
                                  password.setCustomValidity('The password is too long. Enter 6 to 15 characters.');}
                               else {
                                  password.setCustomValidity('Password is invalid. The password must contain only Latin letters or numbers.');
                            }});


                         });

                         paymentSum.addEventListener('input', function (event) {
                            if (paymentSum.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                               paymentSum.setCustomValidity('');}
                            else if (paymentSum.value.match(/^[0-9]+$/)){
                               paymentSum.setCustomValidity('The payment amount must contain 2 digits after the dot');}
                            else if (paymentSum.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                               paymentSum.setCustomValidity('The payment amount must contain 2 digits after the dot');}
                            else if (paymentSum.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                               paymentSum.setCustomValidity('The payment amount must contain 2 digits after the dot');}
                            else if (paymentSum.value === emptyField) {
                               paymentSum.setCustomValidity('Required field');}
                            else {
                               paymentSum.setCustomValidity('The payment amount must contain only numbers');}});

                         if (password.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                            password.setCustomValidity('');}
                         else if (password.value === emptyField) {
                            password.setCustomValidity('Required field');}
                         else if (password.value.length<6){
                            password.setCustomValidity('The password is too short. Enter 6 to 15 characters.');}
                         else if (password.value.length>15){
                            password.setCustomValidity('The password is too long. Enter 6 to 15 characters.');}
                         else {
                            password.setCustomValidity('Password is invalid. The password must contain only Latin letters or numbers.');
                            }


                         password.addEventListener('input', function (event) {
                            if (password.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                               password.setCustomValidity('');}
                            else if (password.value === emptyField) {
                               password.setCustomValidity('Required field');}
                            else if (password.value.length<6){
                               password.setCustomValidity('The password is too short. Enter 6 to 15 characters.');}
                            else if (password.value.length>15){
                               password.setCustomValidity('The password is too long. Enter 6 to 15 characters.');}
                            else {
                               password.setCustomValidity('Password is invalid. The password must contain only Latin letters or numbers.');
                            }});

      }
