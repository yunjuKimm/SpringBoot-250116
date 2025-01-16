package com.ll.basic.domain.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // @Controller 어노테이션을 붙여주면 해당 클래스를 컨트롤러로 인식하게 된다.
public class HomeController {

    @GetMapping("/") // @GetMapping 어노테이션을 붙여주면 / 경로로 들어왔을 때 해당 메소드가 실행된다.
    @ResponseBody // @ResponseBody 어노테이션을 붙여주면 해당 메소드의 리턴값을 브라우저에 보여준다.
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/introduce")
    @ResponseBody
    public String introduce() {
        return "안녕하세요. 저는 홍길동입니다.";
    }

}
