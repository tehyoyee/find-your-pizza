package com.pizzaTest.demo.domain;

import com.pizzaTest.demo.repository.MBTI;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resultTitle;
    private String resultSubTitle;
    private String resultDescription;
    private int[] selectQuestion;
    @Enumerated(EnumType.STRING)
    private MBTI mbti;

    @Builder
    public Result(String resultTitle, String resultSubTitle, String resultDescription, int[] selectQuestion, MBTI mbti, String uuid) {
        this.resultTitle = resultTitle;
        this.resultSubTitle = resultSubTitle;
        this.resultDescription = resultDescription;
        this.selectQuestion = selectQuestion;
        this.mbti = mbti;
    }
}
