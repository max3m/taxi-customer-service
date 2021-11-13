# TaxiCustomerService
## Описание

REST-сервис для обработки запросов клиентов такси. Проверяет наличие клиента в БД, отвечает за создание и изменение заказа.
### Используемый стек технологий
- H2 database
- Open Feign
- Eureca Server

### Порядок запуска микросервисов такси(для разработки)

1. Zookeper и Kafka
2. taxi-eureca
3. taxi-order-service
4. taxi-order-history-service
5. taxi-customer-service
6. taxi-driver-service

# REST API
REST API приложения представлен ниже

## Создание заказа
### Запрос
`POST /api/orders`

    curl -i -H 'Content-Type: application/json' -d '{"username" : "Customer1", "status" : "CREATED"}' http://localhost:5556/api/orderss
### Ответ
    HTTP/1.1 200
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Sat, 12 Nov 2021 16:03:01 GMT
## Обновление заказа(не по заданию)
### Запрос
`PUT /api/orders`

    curl -i -H 'Content-Type: application/json' -d '{"username" : "Customer1", "status" : "CLOSED"}' -X PUT http://localhost:5556/api/orders/11
### Ответ
    HTTP/1.1 201 
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Sat, 12 Nov 2021 16:08:23 GMT

    {"id":15,"username":"Customer1","driverUsername":null,"status":"CLOSED","information":null}% 

# Осталось реализовать
- контейнеризация
- liquibase\flyway
    
 
