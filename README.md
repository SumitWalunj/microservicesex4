# microservicesex4
Microservices-> 2 or more Spring Boot application communicate with each other

Calling Services- 
1. Rest Template
2. Feign Client

DepartmentService-9191
EmployeeService- 9192
APIGateway- 2023
ServiceRegistry-8761
HystrixDashboard- 9193

Zipkin & Sleuth
--------------------------------------------------------------------
Microservices

For Eureka Server-
server.port=8761
spring.application.name=ServiceRegistry
eureka.client.register-with-eureka= false
eureka.client.fetch-registry= false

Hystrix Status->
http://localhost:2023/actuator/hystrix.stream

Hystrix Ping-
http://localhost:9195/hystrix

API Gateway
spring.main.allow-circular-references: true