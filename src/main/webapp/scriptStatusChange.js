 function  onChange(){
                         const passwordCard = document.querySelector('input[name=passwordCard]');


                         var emptyField = '';

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
