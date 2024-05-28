# softLabTest
В рамках тестового задания создано приложение REST-full веб-приложение, дублирующее резюме и являющееся визитной карточкой.
# Технологии
●	Java 17.
●	Spring в качества серверного ядра.
●	Hibernate + JPA.
●	База данных H2.
## Примеры использования
1. Страничный запрос данных с фильтрацией и сортировкой при запросе.

Method: GET 
URL: http://localhost:8080/api/persons/searchPage
Адрес с учетом данных в базе: http://localhost:8080/api/persons/e2ff6e26-8162-4351-86b2-7bce54f7ab6b
Body: No body required

2. Получение данных о человеке по его идентификатору.

Method: GET 
URL: http://localhost:8080/api/persons/
Адрес с учетом данных в базе: http://localhost:8080/api/persons/e2ff6e26-8162-4351-86b2-7bce54f7ab6b
Body: No body required
