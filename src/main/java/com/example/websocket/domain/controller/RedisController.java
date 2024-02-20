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

    @PostMapping("/set")
    public void saveSet(@RequestBody RedisRequestDto requestDto) {
        redisService.saveSet("setKey:" + requestDto.getId(), "setTest" + requestDto.getId());
    }

    @GetMapping("/set/{id}")
    public String getSetValue(@PathVariable String id) {
        return redisService.getSetValue("setKey:" + id);
    }

    @GetMapping("/setAll/{id}")
    public Set<Object> getSetValues(@PathVariable String id) {
        return redisService.getSetValues("setKey:" + id);
    }

    @PostMapping("/zSet")
    public void saveZSet(@RequestBody RedisRequestDto requestDto) {
        redisService.saveZSet("score:" + requestDto.getId(), "value:", requestDto.getValue());
    }

    @GetMapping("/zSetIndex/{id}")
    public Set<Object> getZSetIndexValues(@PathVariable String id) {
        return redisService.getZSetIndexValues("score:" + id);
    }

    @GetMapping("/zSetScore/{id}/{min}/{max}")
    public Set<Object> getZSetScoreValues(@PathVariable String id, @PathVariable int min, @PathVariable int max) {
        return redisService.getZSetScoreValues("score:" + id, min, max);
    }

    @GetMapping("/zSetWithScores/{id}/{min}/{max}")
    public Set<Object> getZSetScoreKeyValues(@PathVariable String id, @PathVariable int min, @PathVariable int max) {
        return redisService.getZSetScoreKeyValues("score:" + id, min, max);
    }

    @PostMapping("/hash")
    public void saveHash(@RequestBody RedisRequestDto requestDto) {
        redisService.saveHash("hashKey:" + requestDto.getId(), "testKey:" + requestDto.getId(), "hashTest" + requestDto.getId());
    }

    @PostMapping("/hashAll")
    public void saveAllHash(@RequestBody RedisRequestDto requestDto) {
        redisService.saveAllHash("hashKey:" + requestDto.getId(), "testKey:" + requestDto.getId(), "hashTest" + requestDto.getId());
    }

    @GetMapping("/hash/{id}")
    public String getHash(@PathVariable String id) {
        return redisService.getHash("hashKey:" + id, "testKey:" + id);
    }

    @GetMapping("/hashKey/{id}")
    public Set<Object> getHashKeys(@PathVariable String id) {
        return redisService.getHashKeys("hashKey:" + id);
    }

    @GetMapping("/hashValue/{id}")
    public List<Object> getHashValues(@PathVariable String id) {
        return redisService.getHashValues("hashKey:" + id);
    }

    @GetMapping("/hashMap/{id}")
    public Map<Object, Object> getHashMaps(@PathVariable String id) {
        return redisService.getHashMaps("hashKey:" + id);
    }
}
