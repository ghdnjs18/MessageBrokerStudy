package com.example.websocket.domain.test;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final SimpMessageSendingOperations template;

    public void sendMessage(ChatRequestDto requestDto) {
        template.convertAndSend("/topic/chatroom/" + requestDto.getRoomId(), requestDto);
    }
}
