 function  onChange(){
                         const email = document.querySelector('input[name=ClientEMail]');
                         const password = document.querySelector('input[name=Password]');
                         const confirm = document.querySelector('input[name=Confirm]');

                         var emptyField = '';

                         if (email.value.match(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/)){
                            email.setCustomValidity('');}
                         else if (email.value === emptyField) {
                            email.setCustomValidity('Required field');}
                         else if (email.value.match(/^([a-zA-Z0-9_\.\-])+$/)){
                            email.setCustomValidity('The e-mail address must contain the "@" sign.');}
                         else {
                            email.setCustomValidity('e-mail is invalid');
                            }

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

                         email.addEventListener('input', function (event) {
                            if (email.value.match(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/)){
                               email.setCustomValidity('');}
                            else if (email.value === emptyField) {
                               email.setCustomValidity('Required field');}
                            else if (email.value.match(/^([a-zA-Z0-9_\.\-])+$/)){
                               email.setCustomValidity('The e-mail address must contain the "@" sign.');}
                            else {
                               email.setCustomValidity('e-mail is invalid');}

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
