package com.pizzaTest.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Servey {
    private int questionId;
    private String questionTitle;
    private String firstQuestion;
    private String secondQuestion;

    public Servey(String questionTitle, String firstQuestion, String secondQuestion) {
        this.questionTitle = questionTitle;
        this.firstQuestion = firstQuestion;
        this.secondQuestion = secondQuestion;
    }
}