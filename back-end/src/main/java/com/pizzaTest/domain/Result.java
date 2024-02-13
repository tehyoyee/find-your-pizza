package com.pizzaTest.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Result {
    private int resultId;
    private String resultTitle;
    private String resultSubTitle;
    private String resultDescription;

    public Result(int resultId, String resultTitle, String resultSubTitle, String resultDescription) {
        this.resultId = resultId;
        this.resultTitle = resultTitle;
        this.resultSubTitle = resultSubTitle;
        this.resultDescription = resultDescription;
    }
}
