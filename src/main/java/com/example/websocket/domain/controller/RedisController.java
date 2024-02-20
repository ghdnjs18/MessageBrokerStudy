package com.example.websocket.domain.controller;

import com.example.websocket.domain.dto.RedisRequestDto;
import com.example.websocket.domain.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/list")
    public void saveList(@RequestBody RedisRequestDto requestDto) {
        redisService.saveList("listKey:" + requestDto.getId(), "listTest" + requestDto.getId());
    }

    @GetMapping("/list/{id}/{index}")
    public String getListValue(@PathVariable String id, @PathVariable long index) {
        return redisService.getListValue("listKey:" + id, index);
    }

    @GetMapping("/listAll/{id}")
    public List<Object> getListValues(@PathVariable String id) {
        return redisService.getListValues("listKey:" + id);
    }
}
