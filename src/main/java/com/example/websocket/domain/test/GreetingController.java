package com.example.websocket.domain.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class GreetingController {

    private final ChatService chatService;

    @MessageMapping("/hello") // publish를 이용해 메시지를 받을 주소
    @SendTo("/topic/greetings") // subscribe을 이용해 메시지를 전송할 주소
    public Greeting greeting(HelloMessage message) {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/chat/sendMessage")
    public void sendMessage(@RequestBody ChatRequestDto requestDto) {
        chatService.sendMessage(requestDto);

        log.info("roomId : " + requestDto.getRoomId() + "sender : " + requestDto.getSenderId() + " receiver : " + requestDto.getReceiverId());
        log.info("message : " + requestDto.getMessage());
    }
}
