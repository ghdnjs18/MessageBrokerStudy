package com.example.websocket.domain.controller;

import com.example.websocket.domain.dto.RedisRequestDto;
import com.example.websocket.domain.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
        redisService.saveList(requestDto.getId(), requestDto.getId());
    }

    @GetMapping("/list/{id}/{index}")
    public String getListValue(@PathVariable String id, @PathVariable long index) {
        return redisService.getListValue(id, index);
    }

    @GetMapping("/listAll/{id}")
    public List<Object> getListValues(@PathVariable String id) {
        return redisService.getListValues(id);
    }

    @PostMapping("/set")
    public void saveSet(@RequestBody RedisRequestDto requestDto) {
        redisService.saveSet(requestDto.getId(), requestDto.getId());
    }

    @GetMapping("/set/{id}")
    public String getSetValue(@PathVariable String id) {
        return redisService.getSetValue(id);
    }

    @GetMapping("/setAll/{id}")
    public Set<Object> getSetValues(@PathVariable String id) {
        return redisService.getSetValues(id);
    }

    @PostMapping("/zSet")
    public void saveZSet(@RequestBody RedisRequestDto requestDto) {
        redisService.saveZSet(requestDto.getId(), requestDto.getValue(), requestDto.getScore());
    }

    @GetMapping("/zSetIndex/{id}")
    public Set<Object> getZSetIndexValues(@PathVariable String id) {
        return redisService.getZSetIndexValues(id);
    }

    @GetMapping("/zSetScore/{id}/{min}/{max}")
    public Set<Object> getZSetScoreValues(@PathVariable String id, @PathVariable int min, @PathVariable int max) {
        return redisService.getZSetScoreValues(id, min, max);
    }

    @GetMapping("/zSetWithScores/{id}/{min}/{max}")
    public Set<Object> getZSetScoreKeyValues(@PathVariable String id, @PathVariable int min, @PathVariable int max) {
        return redisService.getZSetScoreKeyValues(id, min, max);
    }

    @PostMapping("/hash")
    public void saveHash(@RequestBody RedisRequestDto requestDto) {
        redisService.saveHash(requestDto.getId(), requestDto.getId(), requestDto.getValue());
    }

    @PostMapping("/hashAll")
    public void saveAllHash(@RequestBody RedisRequestDto requestDto) {
        redisService.saveAllHash(requestDto.getId(), requestDto.getId(), requestDto.getValue());
    }

    @GetMapping("/hash/{id}")
    public String getHash(@PathVariable String id) {
        return redisService.getHash(id, id);
    }

    @GetMapping("/hashKey/{id}")
    public Set<Object> getHashKeys(@PathVariable String id) {
        return redisService.getHashKeys(id);
    }

    @GetMapping("/hashValue/{id}")
    public List<Object> getHashValues(@PathVariable String id) {
        return redisService.getHashValues(id);
    }

    @GetMapping("/hashMap/{id}")
    public Map<Object, Object> getHashMaps(@PathVariable String id) {
        return redisService.getHashMaps(id);
    }
}
