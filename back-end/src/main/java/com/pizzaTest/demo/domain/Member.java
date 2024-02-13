package com.pizzaTest.demo.domain;

import java.util.UUID;


public class Member {

    // UUID 생성
    private final String uuid = UUID.randomUUID().toString();

    public String getMember() {
        return uuid;
    }
}
