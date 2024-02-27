package com.pizzaTest.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@AllArgsConstructor
@Getter @Setter
public class ResultRequestDto {
    private String[] answers;
}
