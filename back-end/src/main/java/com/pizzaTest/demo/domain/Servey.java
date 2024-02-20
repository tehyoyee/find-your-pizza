package com.pizzaTest.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//<<<<<<< HEAD
//
//=======
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Servey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionTitle;
    private String firstQuestion;
    private String secondQuestion;
    private int[] selectQuestion;
    private String MBTI;
    @Builder
    public Servey(String questionTitle, String firstQuestion, String secondQuestion, int[] selectQuestion, String MBTI) {
        this.questionTitle = questionTitle;
        this.firstQuestion = firstQuestion;
        this.secondQuestion = secondQuestion;
        this.selectQuestion = selectQuestion;
        this.MBTI = MBTI;
    }
}
