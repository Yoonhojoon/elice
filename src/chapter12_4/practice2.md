

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/board
    username: elicer
    password: devpassword
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: create
  profiles:
    active: local

# 지시사항에 맞게 코드를 작성해 보세요.
logging:
  level:
    com.elice.logging.LogController: DEBUG
    com.elice.book.BookReservationController: WARN
    root: INFO
```
