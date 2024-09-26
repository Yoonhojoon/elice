
TokenService
```java
package com.elice.practice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
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
        } catch (JWTVerificationException exception) {
            return false;
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
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String token = tokenService.generateToken(username);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/protected")
    public ResponseEntity<?> accessProtectedResource(@RequestHeader("Authorization") String token) {
        boolean isValidToken = tokenService.validateToken(token);
        if (isValidToken) {
            return ResponseEntity.ok("Access to protected resource granted");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token");
        }
    }


    @Getter
    @NoArgsConstructor
    public static class LoginRequest {
        private String username;
    }
}
```




```java

```




```java

```