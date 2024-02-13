package com.pizzaTest.demo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Member {
    private int userId;
    private UUID uuid;

    public Member() {
    }

    public Member(int userId) {
        this.userId = userId;
    }
}