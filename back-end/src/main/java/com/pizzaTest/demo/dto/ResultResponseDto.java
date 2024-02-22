package com.pizzaTest.demo.dto;

import com.pizzaTest.demo.repository.MBTI;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ResultResponseDto {
    MBTI mbti;
    String resultTitle;
    String resultSubTitle;
    String resultDescription;

    public ResultResponseDto(MBTI mbti, String resultTitle, String resultSubTitle, String resultDescription) {

        this.mbti = mbti;
        this.resultTitle = resultTitle;
        this.resultSubTitle = resultSubTitle;
        this.resultDescription = resultDescription;
    }
}
