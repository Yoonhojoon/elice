
SecurityConfigurationTest
```java
package com.elice.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@WebMvcTest
@Import(SecurityConfiguration.class)
public class SecurityConfigurationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("로그인 페이지 로드")
    void loginPageLoads() throws Exception {
        mockMvc.perform(get("/login-form"))
            .andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인 성공")
    @WithMockUser(username = "elicer", roles = "USER")
    void successfulLogin() throws Exception {
        mockMvc.perform(formLogin("/login").user("elicer").password("1234"))
            .andExpect(authenticated().withUsername("elicer"));
    }

    @Test
    @DisplayName("로그아웃 성공")
    @WithMockUser(username = "elicer", roles = "USER")
    void successfulLogout() throws Exception {
        mockMvc.perform(logout("/logout"))
            .andExpect(unauthenticated())
            .andExpect(redirectedUrl("/"));
    }

}

```
