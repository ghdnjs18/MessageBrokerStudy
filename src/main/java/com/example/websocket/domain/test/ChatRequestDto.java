package com.example.websocket.domain.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatRequestDto {

    private long roomId;
    private long senderId;
    private long receiverId;
    private String message;
}
