package com.spring.mvc.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter @Getter
public class Pet {

    //파라미터들을 필드로 매칭
    private String pet; // 이름 html name이랑 똑같이 맞춰
    private int age;
    private String master;
    private String gender;
    //취미 추가
    private List<String> hobby; // 스트링 배열써도o

    public Pet() {
        System.out.println("커맨드 객체 Pet 생성!!");
    }






}
