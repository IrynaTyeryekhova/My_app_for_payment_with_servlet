 function  onChange(){
                         const newBalance = document.querySelector('input[name=newBalance]');
                         const passwordCard = document.querySelector('input[name=passwordCard]');


                         var emptyField = '';

                         if (newBalance.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                            newBalance.setCustomValidity('');}
                         else if (newBalance.value.match(/^[0-9]+$/)){
                            newBalance.setCustomValidity('The balance must contain 2 digits after the dot');}
                         else if (newBalance.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                            newBalance.setCustomValidity('The balance must contain 2 digits after the dot');}
                         else if (newBalance.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                            newBalance.setCustomValidity('The balance must contain 2 digits after the dot');}
                         else if (newBalance.value === emptyField) {
                            newBalance.setCustomValidity('Required field');}
                         else {
                            newBalance.setCustomValidity('The balance must contain only numbers');}

                         if (passwordCard.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                            passwordCard.setCustomValidity('');}
                         else if (passwordCard.value === emptyField) {
                            passwordCard.setCustomValidity('Required field');}
                         else if (passwordCard.value.length<6){
                            passwordCard.setCustomValidity('The password is too short. Enter 6 to 15 characters.');}
                         else if (passwordCard.value.length>15){
                            passwordCard.setCustomValidity('The password is too long. Enter 6 to 15 characters.');}
                         else {
                            passwordCard.setCustomValidity('Password is invalid. The password must contain only Latin letters or numbers.');
                            }


                         newBalance.addEventListener('input', function (event) {
                            if (newBalance.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                               newBalance.setCustomValidity('');}
                            else if (newBalance.value.match(/^[0-9]+$/)){
                               newBalance.setCustomValidity('The balance must contain 2 digits after the dot');}
                            else if (newBalance.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                               newBalance.setCustomValidity('The balance must contain 2 digits after the dot');}
                            else if (newBalance.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                               newBalance.setCustomValidity('The balance must contain 2 digits after the dot');}
                            else if (newBalance.value === emptyField) {
                               newBalance.setCustomValidity('Required field');}
                            else {
                               newBalance.setCustomValidity('The balance must contain only numbers');}

                            passwordCard.addEventListener('input', function (event) {
                               if (passwordCard.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                                  passwordCard.setCustomValidity('');}
                               else if (passwordCard.value === emptyField) {
                                  passwordCard.setCustomValidity('Required field');}
                               else if (passwordCard.value.length<6){
                                  passwordCard.setCustomValidity('The password is too short. Enter 6 to 15 characters.');}
                               else if (passwordCard.value.length>15){
                                  passwordCard.setCustomValidity('The password is too long. Enter 6 to 15 characters.');}
                               else {
                                  passwordCard.setCustomValidity('Password is invalid. The password must contain only Latin letters or numbers.');
                                  }});

                         });

                         if (passwordCard.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                            passwordCard.setCustomValidity('');}
                         else if (passwordCard.value === emptyField) {
                            passwordCard.setCustomValidity('Required field');}
                         else if (passwordCard.value.length<6){
                            passwordCard.setCustomValidity('The password is too short. Enter 6 to 15 characters.');}
                         else if (passwordCard.value.length>15){
                            passwordCard.setCustomValidity('The password is too long. Enter 6 to 15 characters.');}
                         else {
                            passwordCard.setCustomValidity('Password is invalid. The password must contain only Latin letters or numbers.');
                            }


                         passwordCard.addEventListener('input', function (event) {
                             if (passwordCard.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                                passwordCard.setCustomValidity('');}
                             else if (passwordCard.value === emptyField) {
                                passwordCard.setCustomValidity('Required field');}
                             else if (passwordCard.value.length<6){
                                passwordCard.setCustomValidity('The password is too short. Enter 6 to 15 characters.');}
                             else if (passwordCard.value.length>15){
                                passwordCard.setCustomValidity('The password is too long. Enter 6 to 15 characters.');}
                             else {
                                passwordCard.setCustomValidity('Password is invalid. The password must contain only Latin letters or numbers.');
                         }});


   }
