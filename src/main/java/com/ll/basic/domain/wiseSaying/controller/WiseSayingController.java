package com.ll.basic.domain.wiseSaying.controller;

import com.ll.basic.domain.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.wiseSaying.service.WiseSayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/wiseSaying/write")
    public WiseSaying writeWiseSaying() {
        return wiseSayingService.write("명언1", "작가1");
    }
}