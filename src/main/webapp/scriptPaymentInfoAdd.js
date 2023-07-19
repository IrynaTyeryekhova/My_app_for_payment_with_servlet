 function  onChange(){
                         const paymentSum = document.querySelector('input[name=paymentSum]');
                         const password = document.querySelector('input[name=cardPasswordAddPayment]');

                         var emptyField = '';

                         if (paymentSum.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                            paymentSum.setCustomValidity('');}
                         else if (paymentSum.value.match(/^[0-9]+$/)){
                            paymentSum.setCustomValidity('Сума повинна містити 2 цифри після крапки');}
                         else if (paymentSum.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                            paymentSum.setCustomValidity('Сума повинна містити 2 цифри після крапки');}
                         else if (paymentSum.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                            paymentSum.setCustomValidity('Сума повинна містити 2 цифри після крапки');}
                         else if (paymentSum.value === emptyField) {
                            paymentSum.setCustomValidity('Заповніть поле');}
                         else {
                            paymentSum.setCustomValidity('Сума повинна містити лише цифри та крапку');}


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

                         paymentSum.addEventListener('input', function (event) {
                            if (paymentSum.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                               paymentSum.setCustomValidity('');}
                            else if (paymentSum.value.match(/^[0-9]+$/)){
                               paymentSum.setCustomValidity('Сума повинна містити 2 цифри після крапки');}
                            else if (paymentSum.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                               paymentSum.setCustomValidity('Сума повинна містити 2 цифри після крапки');}
                            else if (paymentSum.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                               paymentSum.setCustomValidity('Сума повинна містити 2 цифри після крапки');}
                            else if (paymentSum.value === emptyField) {
                               paymentSum.setCustomValidity('Заповніть поле');}
                            else {
                               paymentSum.setCustomValidity('Сума повинна містити лише цифри та крапку');}

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

                         paymentSum.addEventListener('input', function (event) {
                            if (paymentSum.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                               paymentSum.setCustomValidity('');}
                            else if (paymentSum.value.match(/^[0-9]+$/)){
                               paymentSum.setCustomValidity('Сума повинна містити 2 цифри після крапки');}
                            else if (paymentSum.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                               paymentSum.setCustomValidity('Сума повинна містити 2 цифри після крапки');}
                            else if (paymentSum.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                               paymentSum.setCustomValidity('Сума повинна містити 2 цифри після крапки');}
                            else if (paymentSum.value === emptyField) {
                               paymentSum.setCustomValidity('Заповніть поле');}
                            else {
                               paymentSum.setCustomValidity('Сума повинна містити лише цифри та крапку');}});


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
