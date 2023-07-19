 function  onChange(){
                         const newBalance = document.querySelector('input[name=newBalance]');
                         const passwordCard = document.querySelector('input[name=passwordCard]');


                         var emptyField = '';

                         if (newBalance.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                            newBalance.setCustomValidity('');}
                         else if (newBalance.value.match(/^[0-9]+$/)){
                            newBalance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                         else if (newBalance.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                            newBalance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                         else if (newBalance.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                            newBalance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                         else if (newBalance.value === emptyField) {
                            newBalance.setCustomValidity('Заповніть поле');}
                         else {
                            newBalance.setCustomValidity('Баланс повинен містити лише цифри та крапку');}

                         if (passwordCard.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                            passwordCard.setCustomValidity('');}
                         else if (passwordCard.value === emptyField) {
                            passwordCard.setCustomValidity('Заповніть поле');}
                         else if (passwordCard.value.length<6){
                             passwordCard.setCustomValidity('Пароль дуже короткий. Введіть від 6 до 15 символів.');}
                         else if (passwordCard.value.length>15){
                             passwordCard.setCustomValidity('Пароль дуже довгий. Введіть від 6 до 15 символів.');}
                         else {
                             passwordCard.setCustomValidity('Пароль повинен містити тільки латинські літери або цифри.');
                         }


                         newBalance.addEventListener('input', function (event) {
                            if (newBalance.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                               newBalance.setCustomValidity('');}
                            else if (newBalance.value.match(/^[0-9]+$/)){
                               newBalance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                            else if (newBalance.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                               newBalance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                            else if (newBalance.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                               newBalance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                            else if (newBalance.value === emptyField) {
                               newBalance.setCustomValidity('Заповніть поле');}
                            else {
                               newBalance.setCustomValidity('Баланс повинен містити лише цифри та крапку');}

                            passwordCard.addEventListener('input', function (event) {
                               if (passwordCard.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                                  passwordCard.setCustomValidity('');}
                               else if (passwordCard.value === emptyField) {
                                  passwordCard.setCustomValidity('Заповніть поле');}
                               else if (passwordCard.value.length<6){
                                  passwordCard.setCustomValidity('Пароль дуже короткий. Введіть від 6 до 15 символів.');}
                               else if (passwordCard.value.length>15){
                                  passwordCard.setCustomValidity('Пароль дуже довгий. Введіть від 6 до 15 символів.');}
                               else {
                                  passwordCard.setCustomValidity('Пароль повинен містити тільки латинські літери або цифри.');
                            }});

                         });

                         if (passwordCard.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                            passwordCard.setCustomValidity('');}
                         else if (passwordCard.value === emptyField) {
                            passwordCard.setCustomValidity('Заповніть поле');}
                         else if (passwordCard.value.length<6){
                             passwordCard.setCustomValidity('Пароль дуже короткий. Введіть від 6 до 15 символів.');}
                         else if (passwordCard.value.length>15){
                             passwordCard.setCustomValidity('Пароль дуже довгий. Введіть від 6 до 15 символів.');}
                         else {
                             passwordCard.setCustomValidity('Пароль повинен містити тільки латинські літери або цифри.');
                         }

                         passwordCard.addEventListener('input', function (event) {
                             if (passwordCard.value.match(/^([a-zA-Z0-9]{6,15}$)/)){
                                passwordCard.setCustomValidity('');}
                             else if (passwordCard.value === emptyField) {
                                passwordCard.setCustomValidity('Заповніть поле');}
                             else if (passwordCard.value.length<6){
                                 passwordCard.setCustomValidity('Пароль дуже короткий. Введіть від 6 до 15 символів.');}
                             else if (passwordCard.value.length>15){
                                 passwordCard.setCustomValidity('Пароль дуже довгий. Введіть від 6 до 15 символів.');}
                             else {
                                 passwordCard.setCustomValidity('Пароль повинен містити тільки латинські літери або цифри.');
                             }});

      }
