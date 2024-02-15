package com.pizzaTest.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter @Setter
@Entity
@RequiredArgsConstructor
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
