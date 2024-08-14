
ContactLoggingAspect.java
```java
package com.elice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ContactLoggingAspect {

    private static Logger log = LoggerFactory.getLogger(ContactLoggingAspect.class);

    @Before("execution(* com.elice.service.ContactService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("[메서드 호출 전] 호출 메서드: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.elice.service.ContactService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("[메서드 호출 후] 호출 메서드: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* com.elice.service.ContactService.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.error("[예외 발생] {} [에러 메시지] {}", joinPoint.getSignature().getName(), ex.getMessage() != null ? ex.getMessage() : "NULL");
    }
}
```


