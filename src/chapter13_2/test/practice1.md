
KeyGenerationControllerTest
```java
package com.elice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Base64;

@SpringBootTest
@AutoConfigureMockMvc
public class KeyGenerationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("문자열 키 생성 테스트")
    public void testGenerateStringKey() throws Exception {
        MvcResult result = mockMvc.perform(get("/generate/string")
                        .param("length", "10"))
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        assertNotNull(response);
        assertEquals(10, response.length());
    }

    @Test
    @DisplayName("바이트 키 생성 테스트")
    public void testGenerateBytesKey() throws Exception {
        MvcResult result = mockMvc.perform(get("/generate/bytes")
                        .param("length", "32"))
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        assertNotNull(response);
        byte[] decodedBytes = Base64.getDecoder().decode(response);
        assertEquals(32, decodedBytes.length);
    }
}
```
