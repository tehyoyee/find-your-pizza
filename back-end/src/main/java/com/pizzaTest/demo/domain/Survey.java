package com.pizzaTest.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionTitle;
    private String firstQuestion;
    private String secondQuestion;

    @Builder
    public Survey(String questionTitle, String firstQuestion, String secondQuestion) {
        this.questionTitle = questionTitle;
        this.firstQuestion = firstQuestion;
        this.secondQuestion = secondQuestion;
    }
}
