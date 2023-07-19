 function  onChange(){
                         const passwordCard = document.querySelector('input[name=passwordCard]');


                         var emptyField = '';


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
