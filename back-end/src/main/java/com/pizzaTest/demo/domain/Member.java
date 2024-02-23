package com.pizzaTest.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    @Builder
    public Member(String uuid) {
        this.uuid = uuid;
    }
}
