package com.pizzaTest.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Member {
    private Long userId;
    private UUID uuid;

    public Member() {
    }

    public Member(Long userId) {
        this.userId = userId;
    }
}