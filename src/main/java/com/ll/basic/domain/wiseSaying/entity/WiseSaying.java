package com.ll.basic.domain.wiseSaying.entity;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WiseSaying {
    private int id;
    private String content;
    private String author;
}