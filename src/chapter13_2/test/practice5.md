

```java
package com.elice.config;

import com.elice.member.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigurationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("admin 페이지 테스트 - admin 유저")
    void testAdminPageAccess() throws Exception {
        // Admin 페이지에 접근하는 테스트 (admin 역할을 가진 사용자로 로그인)
        mockMvc.perform(get("/admin").with(SecurityMockMvcRequestPostProcessors.user("admin").password("1234").roles(Member.Role.ADMIN.name())))
        .andExpect(status().isOk());
    }
    
    @Test
    @DisplayName("admin 페이지 테스트 - user 유저")
    void testAdminPageAccessWithoutAdminRole() throws Exception {
        // Admin 페이지에 접근하는 테스트 (admin 역할을 가지지 않은 사용자로 로그인)
        mockMvc.perform(get("/admin").with(SecurityMockMvcRequestPostProcessors.user("user").password("1234").roles(Member.Role.USER.name())))
        .andExpect(status().isForbidden());
    }
    
    @Test
    @DisplayName("my page 페이지 테스트 - user 유저")
    void testMyPageAccess() throws Exception {
        // My Page에 접근하는 테스트 (user 역할을 가진 사용자로 로그인)
        mockMvc.perform(get("/my-page").with(SecurityMockMvcRequestPostProcessors.user("user").password("1234").roles(Member.Role.USER.name())))
        .andExpect(status().isOk());
    }
    
    @Test
    @DisplayName("my page 페이지 테스트 - 미인증 유저")
    void testHomePageAccess() throws Exception {
        // Home 페이지에 접근하는 테스트 (인증되지 않은 사용자)
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

}
```

