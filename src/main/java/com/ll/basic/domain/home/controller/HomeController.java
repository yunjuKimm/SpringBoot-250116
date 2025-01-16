package com.ll.basic.domain.home.controller;

import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller // @Controller 어노테이션을 붙여주면 스프링부트가 이 클래스를 컨트롤러로 인식하게 된다.
@ResponseBody  // 를 안붙이면 브라우저에 보여주지 않는다. 클래스에 붙이면 모든 메소드에 적용된다.
public class HomeController {

    private int age = 0;

    @Autowired
    private List<Integer> numList;

    @Autowired
    private List<Integer> numList2;


    @GetMapping("/numList2")
    public List<Integer> getNumList2() {
        return numList2;
    }

    @GetMapping("/numList")
    public List<Integer> getNumList() { // 직접 만든 클래스가 아니라면 @Bean 을 통해서 스프링 컨테이너에 등록해줘야 한다
        return numList;
    }

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

    @GetMapping("/mapList")
    public List<Map<String, String>> getMapList() {
        return List.of( // 2개의 Map을 가지는 하나의 List
                Map.of("k1", "v1", "k2", "v2"),
                Map.of("k3", "v3", "k4", "v4")
        );
    }


    @GetMapping("/articleList")
    public List<Article> getArticleList() {
        return List.of(
                Article.builder().title("제목1").body("내용1").isDeleted(false).build(),
                Article.builder().title("제목2").body("내용2").isDeleted(false).build()
        );
    }

    @GetMapping("/articleList.html")
    public String getArticleListHtml() {
        Article a1 = Article.builder().title("aaaa").body("내용1").isDeleted(false).build();
        Article a2 = Article.builder().title("bbbb").body("내용2").isDeleted(false).build();

        List<Article> articleList = List.of(a1, a2);

        String lis = articleList.stream()
                .map(a -> "<li>%s</li>".formatted(a.getTitle()))
                .collect(Collectors.joining());

        return "<ul>" + lis + "</ul>"; // 자바에서 하지 않고, html에서 하려고 template(자바로 작동하는 html)
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