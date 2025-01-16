package com.ll.basic.domain.home.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class HomeConfig {

    @Bean // 스프링이 컨테이너에 담아 빈을 등록할 때 사용하는 어노테이션
    public List<Integer> numList() {
        return List.of(10, 20, 30, 40, 50, 60, 70);
    }

}
