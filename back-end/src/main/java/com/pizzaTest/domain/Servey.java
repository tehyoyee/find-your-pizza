package com.pizzaTest.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Servey {
    private int questionId;
    private String questionTitle;
    private String firstQuestion;
    private String secondQuestion;
    private int[] selectQuestion = new int[12];

    public Servey(String questionTitle, String firstQuestion, String secondQuestion, int[] selectQuestion) {
        this.questionTitle = questionTitle;
        this.firstQuestion = firstQuestion;
        this.secondQuestion = secondQuestion;
        this.selectQuestion = selectQuestion;
    }
}