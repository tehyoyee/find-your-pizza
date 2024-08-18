package com.pizzaTest.demo.domain;

import com.pizzaTest.demo.repository.MBTI;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MBTI mbti;

    private String uuid;

    @Builder
    public Member(String uuid) {
        this.uuid = uuid;
    }

    public void updateMbti(MBTI mbti) {
        this.mbti = mbti;
    }
}
