package com.example.websocket.domain.controller;

import com.example.websocket.domain.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/string")
    public void save() {
        redisService.save("string", "value");
    }

    @GetMapping("/string/{id}")
    public String getValue(@PathVariable String id) {
        return redisService.getValue(id);
    }


}
