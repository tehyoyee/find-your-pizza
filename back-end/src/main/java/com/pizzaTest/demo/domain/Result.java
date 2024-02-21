package com.pizzaTest.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resultTitle;
    private String resultSubTitle;
    private String resultDescription;
    private int[] selectQuestion;
    private String MBTI;

    @Builder
    public Result(String resultTitle, String resultSubTitle, String resultDescription, int[] selectQuestion, String MBTI) {
        this.resultTitle = resultTitle;
        this.resultSubTitle = resultSubTitle;
        this.resultDescription = resultDescription;
        this.selectQuestion = selectQuestion;
        this.MBTI = MBTI;
    }
}
