package com.ll.basic.domain.wiseSaying.controller;

import com.ll.basic.domain.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.wiseSaying.service.WiseSayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // @Controller랑 @ResponseBody를 합친 어노테이션
public class WiseSayingController {
    private WiseSayingService wiseSayingService;

    @Autowired
    public WiseSayingController(WiseSayingService wiseSayingService) {
        this.wiseSayingService = wiseSayingService;
    }

    @GetMapping("/wiseSayings")
    public List<WiseSaying> getWiseSayings() {
        return wiseSayingService.getAllItems();
    }

    @GetMapping("/wiseSayings/write")
    public WiseSaying writeWiseSaying() {
        return wiseSayingService.write("명언1", "작가1");
    }

    //  GET  /wiseSayings  -> 명언들을 가져와라
    //  GET  /wiseSayings/1 -> 명언들 중에서 1번 가져와라
    @GetMapping("/wiseSayings/{id}")  // 스프링이 읽는 주석
    public WiseSaying getItem1(@PathVariable int id) {
        return wiseSayingService.getItem(id).orElse(null);
    }

    @GetMapping("/wiseSayings/{id}/delete") // <- @DeleteMapping("/wiseSayings/{id}") 으로 @뒤에 메소드를 적음
    public boolean deleteItem(@PathVariable int id) {
        return wiseSayingService.deleteById(id);
    }

    @GetMapping("/wiseSayings/{id}/modify")
    public WiseSaying modifyItem(@PathVariable int id, String content, String author) {
        return wiseSayingService.modify(id, content, author);
    }

}