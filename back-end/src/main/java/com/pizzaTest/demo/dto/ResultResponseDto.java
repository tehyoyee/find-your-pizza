package com.pizzaTest.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResultResponseDto {
    String MBTI;
    String resultTitle;
    String resultSubTitle;
    String resultDescription;

    public ResultResponseDto(String resultTitle, String resultSubTitle, String resultDescription) {
    }
}
