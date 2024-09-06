
OutOfStockException
```java
package com.elice.common.exception;

import com.elice.common.enums.ErrorCode;
import lombok.Getter;

/**
 * [지시사항 1]
 * OutOfStockException 클래스 작성
 * 1. ErrorCode OUT_OF_STOCK을 활용
 * 2. RuntimeException 자식 클래스인 RootException을 상속받는다.
 */
@Getter
public class OutOfStockException extends RootException {
    private ErrorCode errorCode;

    public OutOfStockException() {
        super(ErrorCode.OUT_OF_STOCK.getDetailMessage());
        this.errorCode = ErrorCode.OUT_OF_STOCK;
    }
}
```



GlobalExceptionHandler
```java
package com.elice.common.aspect;

import com.elice.common.enums.ErrorCode;
import com.elice.common.exception.OutOfStockException;
import com.elice.common.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * [지시사항 2]
     * OutOfStockException 예외에 대한 ExceptionHandler 추가
     */
    @ExceptionHandler(OutOfStockException.class)
    public ErrorResponse handleInvalidPriceException(OutOfStockException ex) {
        log.error("Global-Handler[OutOfStockException] - {}", ex.getErrorCode().getDetailMessage());
        return new ErrorResponse(ex.getErrorCode());
    }
}


```



MessageController
```java
package com.elice.controller;

import com.elice.chat.service.MessageChatService;
import com.elice.socket.model.MessageModel;
import com.elice.socket.model.OutputMessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
@Controller
public class MessageController {

    private final MessageChatService messageChatService;

    /**
     * [지시사항 3 참고]
     */
    @MessageMapping("/message/send/{chatUuid}")
    @SendTo("/topic/chat/{chatUuid}")
    public OutputMessageModel sendMessage(@Payload MessageModel messageModel,
                                          @DestinationVariable String chatUuid) {
        messageChatService.save(messageModel);
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessageModel(messageModel.getSender(), chatUuid, messageModel.getContent(),
                time, OutputMessageModel.MessageType.CHAT);
    }
}

```



OrderService
```java
package com.elice.order.service;

import com.elice.book.domain.Book;
import com.elice.common.enums.ChatCode;
import com.elice.common.enums.ErrorCode;
import com.elice.common.event.AlarmEvent;
import com.elice.common.exception.OutOfStockException;
import com.elice.order.domain.Order;
import com.elice.order.model.OrderRequest;
import com.elice.order.model.OrderResponse;
import com.elice.repository.book.BookRepository;
import com.elice.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    /**
     * [지시사항 4-1]
     * Spring ApplicationContext publisher 의존성 주입
     */
    private final ApplicationEventPublisher eventPublisher;
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    public OrderResponse saveOrder(OrderRequest orderRequest) {

        //재고 조회
        if (!isStockSufficient(orderRequest)) {
            /**
             * [지시사항 4-2]
             * 1. 이벤트 발행
             *   - 파라미터는 AlarmEvent, ChatCode, ErrorCode 참고
             
             * [지시사항 4-3]
             * 2. OutOfStockException 예외 throw
             */
            eventPublisher.publishEvent(new AlarmEvent(ChatCode.ORDER_ISSUE.getChatUuid(), ErrorCode.OUT_OF_STOCK));
            throw new OutOfStockException();
        }

        Order order = new Order(orderRequest.getBookCode(), orderRequest.getBookName(), orderRequest.getQuantity());
        orderRepository.save(order);

        return new OrderResponse(order.getUuid(), true);
    }

    private boolean isStockSufficient(OrderRequest orderRequest) {
        Book book = bookRepository.findByBookCode(orderRequest.getBookCode());
        return orderRequest.getQuantity() <= book.getQuantity();
    }

}

```


MessagePushEventListener
```java
package com.elice.common.event;

import com.elice.chat.service.MessageService;
import com.elice.common.enums.ErrorCode;
import com.elice.socket.model.MessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessagePushEventListener {

    private final MessageService messageService;

    @EventListener
    public void eventListener(AlarmEvent event) {
        String chatUuid = event.getChatUuid();
        ErrorCode errorCode = (ErrorCode) event.getSource();
        MessageModel messageModel = new MessageModel(chatUuid, "관리자", errorCode.getDetailMessage());
        /**
         * [지시사항 5]
         * 메시지의 목적지와 messageModel 객체를 파라미터에 담아 messageService의 sendMessage 메서드를 호출한다.
         */
        messageService.sendMessage("/topic/chat/"+chatUuid, messageModel);

    }
}

```

MessageService
```java
package com.elice.chat.service;

import com.elice.socket.model.MessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MessageService {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageChatService messageChatService;

    @Transactional
    public void sendMessage(String destination, MessageModel messageModel) {
        try {
            //[지시사항 6]
            messagingTemplate.convertAndSend(destination, messageModel);

        } catch (MessagingException me) {
            throw new MessagingException("ab");
        }

        messageChatService.save(messageModel);

    }
}

```