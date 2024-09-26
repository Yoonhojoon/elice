
TokenService
```java
package com.elice.practice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private final String secretKey = "yourSecretKey";

    public String generateToken(String username) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1시간 후 만료
                .sign(algorithm);
    }

    public boolean validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (TokenExpiredException e) {
            return true; // 토큰 만료
        } catch (JWTVerificationException e) {
            return false; // 토큰 검증 실패
        }
    }
}
```



AuthenticationController
```java
package com.elice.practice.controller;

import com.elice.practice.service.TokenService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.auth0.jwt.JWT;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.auth0.jwt.JWT;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

        private final TokenService tokenService;

        @PostMapping("/refreshToken")
        public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String token) {
                String username = JWT.decode(token).getSubject();

                if (tokenService.validateToken(token)) {
                    return ResponseEntity.ok(tokenService.generateToken(username));
                }

                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token");
        }
}
```




```java

```




```java

```