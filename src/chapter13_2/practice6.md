

```java
package com.elice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public TextEncryptor textEncryptor() {
        // 지시사항을 참고하여 코드를 작성해보세요
        
        String password = "ElicePassword";
        String salt = KeyGenerators.string().generateKey();
        return Encryptors.text(password, salt);

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // CSRF 보호 비활성화 (원하는 경우 활성화 가능)
                .authorizeRequests()
                .anyRequest().permitAll()  // 모든 요청을 인증 없이 허용
                .and()
                .formLogin().disable()  // 기본 로그인 폼 비활성화
                .httpBasic().disable(); // HTTP 기본 인증 비활성화

        return http.build();
    }

}
```

