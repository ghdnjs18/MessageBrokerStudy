package com.example.websocket.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RedisRequestDto {
    private String id;
    private int value;
}
