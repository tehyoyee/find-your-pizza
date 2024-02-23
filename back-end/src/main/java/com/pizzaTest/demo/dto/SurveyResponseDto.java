package com.pizzaTest.demo.dto;


import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class SurveyResponseDto {
    private Long id;
    private String questionTitle;
    private String firstQuestion;
    private String secondQuestion;
}
