package com.pizzaTest.domain;

import lombok.Getter;

import java.util.UUID;


// uuid set할 필요없으니 일단 getter만
@Getter
public class Member {

    // UUID 생성
    private String uuid = UUID.randomUUID().toString();

    // UUID 가져올 일이 있나? 일단 생성자 생성했음
    public Member(String uuid) {
        this.uuid = uuid;
    }
}
