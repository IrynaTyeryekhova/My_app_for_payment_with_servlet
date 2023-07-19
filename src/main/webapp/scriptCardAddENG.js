 function  onChange(){
                         const cardNumber = document.querySelector('input[name=cardNumberAdd]');
                         const balance = document.querySelector('input[name=cardBalance]');
                         const period = document.querySelector('input[name=cardPeriod]');
                         const password = document.querySelector('input[name=cardPassword]');
                         const confirm = document.querySelector('input[name=cardConfirm]');

                         var emptyField = '';

                         if (cardNumber.value.match(/^([0-9]{16}$)/)){
                            cardNumber.setCustomValidity('');}
                         else if (cardNumber.value === emptyField) {
                            cardNumber.setCustomValidity('Required field');}
                         else if (cardNumber.value.length<16){
                            cardNumber.setCustomValidity('The number is too short. Enter 16 characters.');}
                         else if (cardNumber.value.length>16){
                            cardNumber.setCustomValidity('The number is too long. Enter 16 characters.');}
                         else {
                            cardNumber.setCustomValidity('The number must contain only numbers');}

                         if (balance.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                            balance.setCustomValidity('');}
                         else if (balance.value.match(/^[0-9]+$/)){
                            balance.setCustomValidity('The balance must contain 2 digits after the dot');}
                         else if (balance.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                            balance.setCustomValidity('The balance must contain 2 digits after the dot');}
                         else if (balance.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                            balance.setCustomValidity('The balance must contain 2 digits after the dot');}
                         else if (balance.value === emptyField) {
                            balance.setCustomValidity('Required field');}
                         else {
                            balance.setCustomValidity('The balance must contain only numbers');}

                         if (period.value.match(/^[2]{1}[0]{1}[2-9]{1}[3-9]{1}(\-){1}[0-1]{1}[0-9]{1}(\-){1}[0-3]{1}[0-9]{1}$/)){
                            period.setCustomValidity('');}
                         else if (period.value === emptyField) {
                            period.setCustomValidity('Required field');}
                         else {
                            period.setCustomValidity('Enter a valid date in YYYY-MM-DD format');}

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

                         if (confirm.value === emptyField) {
                            confirm.setCustomValidity('Required field');}
                         else if (confirm.value === password.value) {
                            confirm.setCustomValidity('');}
                         else {
                            confirm.setCustomValidity('Passwords do not match');}



                         cardNumber.addEventListener('input', function (event) {
                            if (cardNumber.value.match(/^([0-9]{16}$)/)){
                               cardNumber.setCustomValidity('');}
                            else if (cardNumber.value === emptyField) {
                               cardNumber.setCustomValidity('Required field');}
                            else if (cardNumber.value.length<16){
                               cardNumber.setCustomValidity('The number is too short. Enter 16 characters.');}
                            else if (cardNumber.value.length>16){
                               cardNumber.setCustomValidity('The number is too long. Enter 16 characters.');}
                            else {
                               cardNumber.setCustomValidity('The number must contain only numbers');}

                            balance.addEventListener('input', function (event) {
                               if (balance.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                                  balance.setCustomValidity('');}
                               else if (balance.value.match(/^[0-9]+$/)){
                                  balance.setCustomValidity('The balance must contain 2 digits after the dot');}
                               else if (balance.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                                  balance.setCustomValidity('The balance must contain 2 digits after the dot');}
                               else if (balance.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                                  balance.setCustomValidity('The balance must contain 2 digits after the dot');}
                               else if (balance.value === emptyField) {
                                  balance.setCustomValidity('Required field');}
                               else {
                                  balance.setCustomValidity('The balance must contain only numbers');}});

                            period.addEventListener('input', function (event) {
                               if (period.value.match(/^[2]{1}[0]{1}[2-9]{1}[3-9]{1}(\-){1}[0-1]{1}[0-9]{1}(\-){1}[0-3]{1}[0-9]{1}$/)){
                                  period.setCustomValidity('');}
                               else if (period.value === emptyField) {
                                  period.setCustomValidity('Required field');}
                               else {
                                  period.setCustomValidity('Enter a valid date in YYYY-MM-DD format');}});

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

                            confirm.addEventListener('input', function (event) {
                               if (confirm.value === password.value) {
                                  confirm.setCustomValidity('');}
                               else {
                                  confirm.setCustomValidity('Passwords do not match');
                            }});

                         });

                         balance.addEventListener('input', function (event) {
                            if (balance.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                               balance.setCustomValidity('');}
                            else if (balance.value.match(/^[0-9]+$/)){
                               balance.setCustomValidity('The balance must contain 2 digits after the dot');}
                            else if (balance.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                               balance.setCustomValidity('The balance must contain 2 digits after the dot');}
                            else if (balance.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                               balance.setCustomValidity('The balance must contain 2 digits after the dot');}
                            else if (balance.value === emptyField) {
                               balance.setCustomValidity('Required field');}
                            else {
                               balance.setCustomValidity('The balance must contain only numbers and dot');}});

                         period.addEventListener('input', function (event) {
                            if (period.value.match(/^[2]{1}[0]{1}[2-9]{1}[3-9]{1}(\-){1}[0-1]{1}[0-9]{1}(\-){1}[0-3]{1}[0-9]{1}$/)){
                               period.setCustomValidity('');}
                            else if (period.value === emptyField) {
                               period.setCustomValidity('Required field');}
                            else {
                               period.setCustomValidity('Enter a valid date in YYYY-MM-DD format');}});

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

                         if (confirm.value === emptyField) {
                            confirm.setCustomValidity('Required field');}

                         confirm.addEventListener('input', function (event) {
                            if (confirm.value === password.value) {
                               confirm.setCustomValidity('');}
                            else {
                               confirm.setCustomValidity('Passwords do not match');
                         }});
      }
