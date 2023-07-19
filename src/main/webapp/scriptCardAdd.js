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
                            cardNumber.setCustomValidity('Заповніть поле');}
                         else if (cardNumber.value.length<16){
                            cardNumber.setCustomValidity('Номер дуже короткий. Введіть 16 символів.');}
                         else if (cardNumber.value.length>16){
                            cardNumber.setCustomValidity('Номер дуже довгий. Введіть 16 символів.');}
                         else {
                            cardNumber.setCustomValidity('Номер повинен містити лише цифри');}

                         if (balance.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                            balance.setCustomValidity('');}
                         else if (balance.value.match(/^[0-9]+$/)){
                            balance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                         else if (balance.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                            balance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                         else if (balance.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                            balance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                         else if (balance.value === emptyField) {
                            balance.setCustomValidity('Заповніть поле');}
                         else {
                            balance.setCustomValidity('Баланс повинен містити лише цифри та крапку');}

                         if (period.value.match(/^[2]{1}[0]{1}[2-9]{1}[3-9]{1}(\-){1}[0-1]{1}[0-9]{1}(\-){1}[0-3]{1}[0-9]{1}$/)){
                            period.setCustomValidity('');}
                         else if (period.value === emptyField) {
                            period.setCustomValidity('Заповніть поле');}
                         else {
                            period.setCustomValidity('Вкажіть дійсну дату в форматі РРРР-ММ-ДД');}

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

                         if (confirm.value === emptyField) {
                            confirm.setCustomValidity('Заповніть поле');}
                         else if (confirm.value === password.value) {
                            confirm.setCustomValidity('');}
                         else {
                            confirm.setCustomValidity('Паролі не співпадають');}



                         cardNumber.addEventListener('input', function (event) {
                            if (cardNumber.value.match(/^([0-9]{16}$)/)){
                               cardNumber.setCustomValidity('');}
                            else if (cardNumber.value === emptyField) {
                               cardNumber.setCustomValidity('Заповніть поле');}
                            else if (cardNumber.value.length<16){
                               cardNumber.setCustomValidity('Номер дуже короткий. Введіть 16 символів.');}
                            else if (cardNumber.value.length>16){
                               cardNumber.setCustomValidity('Номер дуже довгий. Введіть 16 символів.');}
                            else {
                               cardNumber.setCustomValidity('Номер повинен містити лише цифри');}

                            balance.addEventListener('input', function (event) {
                               if (balance.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                                  balance.setCustomValidity('');}
                               else if (balance.value.match(/^[0-9]+$/)){
                                  balance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                               else if (balance.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                                  balance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                               else if (balance.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                                  balance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                               else if (balance.value === emptyField) {
                                  balance.setCustomValidity('Заповніть поле');}
                               else {
                                  balance.setCustomValidity('Баланс повинен містити лише цифри та крапку');}});

                            period.addEventListener('input', function (event) {
                               if (period.value.match(/^[2]{1}[0]{1}[2-9]{1}[3-9]{1}(\-){1}[0-1]{1}[0-9]{1}(\-){1}[0-3]{1}[0-9]{1}$/)){
                                  period.setCustomValidity('');}
                               else if (period.value === emptyField) {
                                  period.setCustomValidity('Заповніть поле');}
                               else {
                                  period.setCustomValidity('Вкажіть дійсну дату в форматі РРРР-ММ-ДД');}});

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

                            confirm.addEventListener('input', function (event) {
                               if (confirm.value === password.value) {
                                  confirm.setCustomValidity('');}
                               else {
                                  confirm.setCustomValidity('Паролі не співпадають');
                            }});

                         });

                         balance.addEventListener('input', function (event) {
                            if (balance.value.match(/^([0-9]{1,6}\.){1}[0-9]{2}$/)){
                               balance.setCustomValidity('');}
                            else if (balance.value.match(/^[0-9]+$/)){
                               balance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                            else if (balance.value.match(/^[0-9]{1,6}\.[0-9]{3,}?$/)){
                               balance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                            else if (balance.value.match(/^[0-9]{1,6}((\.)[0-9]{0,1})$/)){
                               balance.setCustomValidity('Баланс повинен містити 2 цифри після крапки');}
                            else if (balance.value === emptyField) {
                               balance.setCustomValidity('Заповніть поле');}
                            else {
                               balance.setCustomValidity('Баланс повинен містити лише цифри та крапку');}});

                         period.addEventListener('input', function (event) {
                            if (period.value.match(/^[2]{1}[0]{1}[2-9]{1}[3-9]{1}(\-){1}[0-1]{1}[0-9]{1}(\-){1}[0-3]{1}[0-9]{1}$/)){
                               period.setCustomValidity('');}
                            else if (period.value === emptyField) {
                               period.setCustomValidity('Заповніть поле');}
                            else {
                               period.setCustomValidity('Вкажіть дійсну дату в форматі РРРР-ММ-ДД');}});

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

                         if (confirm.value === emptyField) {
                            confirm.setCustomValidity('Заповніть поле');}

                         confirm.addEventListener('input', function (event) {
                            if (confirm.value === password.value) {
                               confirm.setCustomValidity('');}
                            else {
                               confirm.setCustomValidity('Паролі не співпадають');
                         }});
      }
