

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

logging:
  level:
    root: INFO
    # 지시사항을 참고하여 코드를 작성해 보세요.
    com.elice.service.ContactService: DEBUG
```

