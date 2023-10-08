# Веб-приложение "Заметки"

---

### Обзор

Веб-приложение "Заметки" предназначено для создания, просмотра, редактирования и удаления заметок.  
Веб-приложение доступно по следующему URL: http://localhost:8080/api

---

### Функционал веб-приложения:

1. Создание новых заметок с указанием заголовка, текста (если необходим) и с возможностью вставки изображений;
2. Просмотр списка всех созданных заметок;
3. Просмотр конкретной заметки;
4. Редактирование заметки с возможностью заменить существующее изображение или добавить новое;
5. Удаление заметок.

---

### Использованные технологии:

- Java 17;
- Spring Boot 3:
    - Spring Boot Starter Parent 3.1.4;
    - Spring Boot Starter Data JPA;
    - Spring Boot Starter Thymeleaf;
    - Spring Boot Starter Validation;
    - Spring Boot Starter Web;
    - Spring Boot DevTools;
- Apache Maven;
- PostgreSQL;
- Project Lombok;
- ModelMapper;
- Bootstrap 5.

---

### Результаты работы веб-приложения:

#### 1) Первый запуск веб-приложения и открытие в браузере URL: http://localhost:8080/api.
При открытии этого URL и отсутствии созданных заметок происходит перенаправление на страницу создания новой заметки c 
URL: http://localhost:8080/api/notes/new. Эта же страница открывается при создании новой заметки, путём нажатии кнопки 
"Создать заметку" на странице списка всех заметок.  
![Первый запуск](https://github.com/MicCchaelS/notes-api/blob/main/src/main/resources/response%20pages/Первый%20запуск.jpg?raw=true)
#### 2) Список всех заметок, доступный по кнопке "Все заметки" на любой странице. URL: http://localhost:8080/api/notes
![Список заметок](https://github.com/MicCchaelS/notes-api/blob/main/src/main/resources/response%20pages/Список%20заметок.jpg?raw=true)
Страница с пустым списком заметок:  
![Пустой список заметок](https://github.com/MicCchaelS/notes-api/blob/main/src/main/resources/response%20pages/Пустой%20список%20заметок.jpg?raw=true)
#### 3) Отображение заметки после создания или при нажатии кнопки "Подробнее" на странице списка всех заметок. URL: http://localhost:8080/api/notes/1, где 1 - id конкретной заметки.  
![Заметка](https://github.com/MicCchaelS/notes-api/blob/main/src/main/resources/response%20pages/Заметка.jpg?raw=true)
#### 4) Редактирование заметки, доступное по кнопке "Редактировать" на странице заметки. URL: http://localhost:8080/api/notes/1/edit  
![Редактирование заметки](https://github.com/MicCchaelS/notes-api/blob/main/src/main/resources/response%20pages/Редактирование%20заметки.jpg?raw=true)
