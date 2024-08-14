
FactorialConfig.java

```java
package com.elice.factorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

@Configuration
@EnableAspectJAutoProxy
public class FactorialConfig {
    
    // 지시사항에 따라 코드를 작성해 보세요. 
    @Bean
    @Order(2)
    public FactorialTimeAspect factorialTimeAspect() {
        return new FactorialTimeAspect();
    }

    @Bean
    @Order(1)
    public FactorialLoggingAspect factorialLoggingAspect() {
        return new FactorialLoggingAspect();
    }

    @Bean
    public Factorial factorial() {
        return new FactorialWithRecursion();
    }
}
```




```java

```




```java

```




```java

```