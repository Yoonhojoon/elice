
WebSocketStompConfig
```java
package com.elice.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //[지시사항 1-1번] (참고사항 : setAllowedOriginPatterns("*") 추가 필요)
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //[지시사항 1-2번]
        config.setApplicationDestinationPrefixes("/app").enableSimpleBroker("/topic", "/queue");
    }
}

```



WebSocketController
```java
package com.elice.controller;


import com.elice.socket.model.MessageModel;
import com.elice.socket.model.OutputMessageModel;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class WebSocketController {

    //[지시사항 2-1]
    //[지시사항 2-2]
    @MessageMapping("/message/send/{chatUuid}")
    @SendTo("/topic/chat/{chatUuid}")
    public OutputMessageModel sendMessage(@Payload MessageModel messageModel, @DestinationVariable String chatUuid) {
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessageModel(messageModel.getSender(), messageModel.getChatUuid(),
                messageModel.getContent(), time, OutputMessageModel.MessageType.CHAT);
    }
}
```

