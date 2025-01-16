package com.ll.basic.domain.home.controller;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller // @Controller 어노테이션을 붙여주면 스프링부트가 이 클래스를 컨트롤러로 인식하게 된다.
public class HomeController {

    private int age = 0;

    @GetMapping("/") // @GetMapping 어노테이션을 붙여주면 / 경로로 들어왔을 때 이 메소드가 실행된다.
    @ResponseBody // @ResponseBody 어노테이션을 붙여주면 메서드의 리턴값을 브라우저에 보여준다.
    public String home() {
        return "hello";
    }

    @GetMapping("/introduce")
    @ResponseBody
    public String introduce() {
        return "안녕하세요. 저는 홍길동입니다.";
    }

    @GetMapping("/ageUp")
    @ResponseBody
    public int ageUp() {
        age++;
        return age;
    }

    @GetMapping("/byte")
    @ResponseBody
    public byte getByte() {
        return 1;
    }

    @GetMapping("/short")
    @ResponseBody
    public short getShort() {
        return 1;
    }

    @GetMapping("/long")
    @ResponseBody
    public long getLong() {
        return 1;
    }

    @GetMapping("/float")
    @ResponseBody
    public float getFloat() {
        return 3.14f;
    }

    @GetMapping("/double")
    @ResponseBody
    public double getDouble() {
        return 3.14;
    }

    @GetMapping("/char")
    @ResponseBody
    public char getChar() {
        return '안';
    }

    @GetMapping("/boolean")
    @ResponseBody
    public boolean getBoolean() {
        return true;
    }

    @GetMapping("/array")
    @ResponseBody
    public String[] getArray() {
        return new String[]{"a", "b", "c"};
    }

    @GetMapping("/list")
    @ResponseBody
    public List<String> getList() {
        return List.of("a", "b", "c");
    }

    @GetMapping("/map")
    @ResponseBody
    public Map<String, String> getMap() {
        return Map.of("k1", "v1", "k2", "v2");
    }

    @GetMapping("/article")
    @ResponseBody
    public Article getArticle() {
        return Article.builder()
                .body("내용")
                .title("제목")
                .isDeleted(false)
                .build();
    }
}

@Getter
@Builder // @Builder 어노테이션을 붙여주면 Article.builder() 메소드를 사용할 수 있다.
class Article {

    @Builder.Default // @Builder.Default 어노테이션을 붙여주면 기본값을 설정할 수 있다.
    private int id = 1;
    private final String title;
    private final String body;
    private boolean isDeleted;
}