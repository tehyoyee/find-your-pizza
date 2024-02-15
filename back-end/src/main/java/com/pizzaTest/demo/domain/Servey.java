package com.pizzaTest.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public Servey(String questionTitle, String firstQuestion, String secondQuestion) {
        this.questionTitle = questionTitle;
        this.firstQuestion = firstQuestion;
        this.secondQuestion = secondQuestion;
    }
}