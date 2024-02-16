package com.pizzaTest.demo.domain;

<<<<<<< HEAD
import java.util.UUID;


public class Member {

    // UUID 생성
    private final String uuid = UUID.randomUUID().toString();

    public String getMember() {
        return uuid;
=======
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter @Setter
@Entity
//@RequiredArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    @Builder
    public Member(String uuid) {
        this.uuid = uuid;
>>>>>>> 7d39abeaca2303565317fc99db785cb459ef13b3
    }
}
