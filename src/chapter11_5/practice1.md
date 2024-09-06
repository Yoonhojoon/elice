
WebSocketConfig
```java
package com.elice.socket.config;

import com.elice.socket.handler.WebSocketHandlerImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
//[지시사항2] - WebSocket을 사용하기 위한 어노테이션 추가
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    //[지시사항3] - `/websocket-endpoint` 경로의 엔드포인트를 가지는 `WebSocketHandlerImpl` 핸들러를 추가
    registry.addHandler(new WebSocketHandlerImpl(), "/websocket-endpoint");
    }
}
```



WebSocketHandlerImpl
```java
package com.elice.socket.handler;

import org.springframework.web.socket.*;

//[지시사항3] - WebSocket을 핸들링하기 위한 인터페이스 구현
public class WebSocketHandlerImpl implements WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("WebSocket 연결 성공!");
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage) {
            String payload = ((TextMessage) message).getPayload();
            System.out.println("Received message: " + payload);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.err.println("WebSocket 오류 발생: " + exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("WebSocket 연결 종료!");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}

```




```java

```




```java

```