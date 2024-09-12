

```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa:3.2.0'
    implementation 'org.springframework.boot:spring-boot-starter-validation:3.2.0'
    implementation 'org.springframework.boot:spring-boot-starter-jdbc:3.2.0'
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf:3.2.0'
    implementation 'org.springframework.boot:spring-boot-starter-web:3.2.0'
	  implementation 'org.springframework.boot:spring-boot-starter-websocket:3.2.0'    
    implementation 'com.google.code.gson:gson:2.10.1'
    implementation 'com.h2database:h2:2.2.224'
    implementation 'org.mapstruct:mapstruct:1.5.5.Final'
    compileOnly 'org.projectlombok:lombok:1.18.30'
    runtimeOnly 'com.mysql:mysql-connector-j:8.2.0'
    annotationProcessor 'org.projectlombok:lombok:1.18.30'
    annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.5.Final'
    testImplementation 'org.springframework.boot:spring-boot-starter-test:3.2.0'
      
    
    
    
    implementation 'org.springframework.boot:spring-boot-starter-aop:3.2.0'
    
    
    
}

tasks.named('bootBuildImage') {
    builder = 'paketobuildpacks/builder-jammy-base:latest'
}

tasks.named('test') {
    useJUnitPlatform()
}
```



LoggingAspect
```java
  // 지시사항을 참고하여 코드를 작성해 보세요.
	@Aspect
	@Component
	public class LoggingAspect {

	    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	    @Around("execution(* com.elice.service.*.*(..))")
	    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
	        String methodName = joinPoint.getSignature().getName();
	        String className = joinPoint.getTarget().getClass().getSimpleName();

	        logger.info("------------------------------------------------------------------");
	        logger.info("메소드 접근 : {}() in class: {}", methodName, className);

	        long startTime = System.currentTimeMillis();
	        Object result = joinPoint.proceed();
	        long endTime = System.currentTimeMillis();

	        logger.info("메소드 탈출: {}() in class: {}. Execution time: {} ms", methodName, className, (endTime - startTime));
	        logger.info("------------------------------------------------------------------");

	        return result;
	    }
	}
	
	
```




```java

```




```java

```