package com.pizzaTest.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionRequestDto {
    int[] selectQuestion;
    String userMBTI;
}
