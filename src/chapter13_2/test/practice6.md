
SecretMessageControllerTest
```java
package com.elice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.elice.dto.EncryptedMessageRequest;
import com.elice.dto.EncryptedMessageResponse;
import com.elice.dto.MessageRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class SecretMessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        this.objectMapper = Jackson2ObjectMapperBuilder.json().build();
    }

    @Test
    @DisplayName("메시지 암호화 및 복호화 API 테스트")
    public void testEncryptionAndDecryptionApi() throws Exception {
        String originalMessage = "Hello, World!";
        MessageRequest request = new MessageRequest(originalMessage);

        // 암호화 테스트
        MvcResult encryptResult = mockMvc.perform(post("/api/encrypt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.encryptedMessage").exists())
                .andReturn();

        String responseContent = encryptResult.getResponse().getContentAsString();
        EncryptedMessageResponse encryptedResponse = objectMapper.readValue(responseContent, EncryptedMessageResponse.class);
        String encryptedMessage = encryptedResponse.getEncryptedMessage();

        assertNotEquals(originalMessage, encryptedMessage);

        // 복호화 테스트
        EncryptedMessageRequest decryptRequest = new EncryptedMessageRequest(encryptedMessage);
        mockMvc.perform(post("/api/decrypt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(decryptRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.decryptedMessage").value(originalMessage));
    }
}
```