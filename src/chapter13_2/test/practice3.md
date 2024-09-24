
ApplicationTest
```java
package com.elice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("/elice-cloud-track 엔드포인트는 인증 없이 호출할 수 없음")
    public void testFailedAuthentication() throws Exception {
        mvc.perform(get("/elice-cloud-track"))
                .andExpect(unauthenticated());
    }

    @Test
    @DisplayName("권한이 없는 사용자는 인증은 가능하지만 /elice-cloud-track을 호출할 권한이 없음")
    @WithUserDetails("elice")
    public void testSuccessfulAuthentication() throws Exception {
        mvc.perform(get("/elice-cloud-track"))
                .andExpect(authenticated())
                .andExpect(status().isForbidden());
    }

    @Test
    @DisplayName("권한이 있는 사용자는 인증 후 /elice-cloud-track을 호출할 수 있음")
    @WithUserDetails("elicer")
    public void testSuccessfulAuthorization() throws Exception {
        mvc.perform(get("/elice-cloud-track"))
                .andExpect(authenticated())
                .andExpect(status().isOk());
    }



}
```




```java

```




```java

```




```java

```