
ContactLoggingAspect
```java
package com.elice.aop;

import com.elice.exception.ContactNotFoundException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Spring AOP를 사용한 로깅 Aspect 클래스
@Aspect // AOP 클래스임을 명시
@Component // 스프링 빈으로 등록
public class ContactLoggingAspect {

    // 테스트를 위한 Logger 인스턴스
    private Logger log = LoggerFactory.getLogger(ContactLoggingAspect.class);

    // 테스트용으로 Logger를 외부에서 설정할 수 있게 함
    public void setLogger(Logger logger) {
        this.log = logger;
    }

    // 포인트컷 정의
    // com.elice.service 패키지 내 모든 메서드 대상
    @Pointcut("execution(* * com.elice.service.*.*(..))") 
    private void targetMethod(){}

    // 예외 발생 시 로깅 처리
    // ContactNotFoundException이 발생한 경우 로그 기록
    @AfterThrowing(pointcut = "targetMethod()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, ContactNotFoundException ex) {
        // 예외가 발생한 메서드명과 예외 메시지 로그 기록
        log.error("[예외 발생] 메서드: {}, 에러 메시지: {}", joinPoint.getSignature().toShortString(), ex.getMessage());
    }
}

```

