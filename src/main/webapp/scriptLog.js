 function  onChange(){
                         const email = document.querySelector('input[name=ClientEMail]');
                         const password = document.querySelector('input[name=Password]');


                         var emptyField = '';

                         if (email.value.match(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/)){
                            email.setCustomValidity('');}
                         else if (email.value === emptyField) {
                            email.setCustomValidity('Заповніть поле');}
                         else if (email.value.match(/^([a-zA-Z0-9_\.\-])+$/)){
                            email.setCustomValidity('Ел. адреса повинна містити символ "@".');}
                         else {
                            email.setCustomValidity('Ел. адреса містить помилки');}

                         if (password.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                            password.setCustomValidity('');}
                         else if (password.value === emptyField) {
                            password.setCustomValidity('Заповніть поле');}
                         else if (password.value.length<6){
                             password.setCustomValidity('Пароль дуже короткий. Введіть від 6 до 15 символів.');}
                         else if (password.value.length>15){
                             password.setCustomValidity('Пароль дуже довгий. Введіть від 6 до 15 символів.');}
                         else {
                             password.setCustomValidity('Пароль повинен містити тільки латинські літери або цифри.');
                         }


                         email.addEventListener('input', function (event) {
                            if (email.value.match(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/)){
                               email.setCustomValidity('');}
                            else if (email.value === emptyField) {
                               email.setCustomValidity('Заповніть поле');}
                            else if (email.value.match(/^([a-zA-Z0-9_\.\-])+$/)){
                               email.setCustomValidity('Ел. адреса повинна містити символ "@".');}
                            else {
                               email.setCustomValidity('Ел. адреса містить помилки');}

                            password.addEventListener('input', function (event) {
                               if (password.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                                  password.setCustomValidity('');}
                               else if (password.value === emptyField) {
                                  password.setCustomValidity('Заповніть поле');}
                               else if (password.value.length<6){
                                  password.setCustomValidity('Пароль дуже короткий. Введіть від 6 до 15 символів.');}
                               else if (password.value.length>15){
                                  password.setCustomValidity('Пароль дуже довгий. Введіть від 6 до 15 символів.');}
                               else {
                                  password.setCustomValidity('Пароль повинен містити тільки латинські літери або цифри.');
                            }});

                         });

                         if (password.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                            password.setCustomValidity('');}
                         else if (password.value === emptyField) {
                            password.setCustomValidity('Заповніть поле');}
                         else if (password.value.length<6){
                             password.setCustomValidity('Пароль дуже короткий. Введіть від 6 до 15 символів.');}
                         else if (password.value.length>15){
                             password.setCustomValidity('Пароль дуже довгий. Введіть від 6 до 15 символів.');}
                         else {
                             password.setCustomValidity('Пароль повинен містити тільки латинські літери або цифри.');
                         }

                         password.addEventListener('input', function (event) {
                            if (password.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                               password.setCustomValidity('');}
                            else if (password.value === emptyField) {
                               password.setCustomValidity('Заповніть поле');}
                            else if (password.value.length<6){
                               password.setCustomValidity('Пароль дуже короткий. Введіть від 6 до 15 символів.');}
                            else if (password.value.length>15){
                               password.setCustomValidity('Пароль дуже довгий. Введіть від 6 до 15 символів.');}
                            else {
                               password.setCustomValidity('Пароль повинен містити тільки латинські літери або цифри.');
                         }});

      }
