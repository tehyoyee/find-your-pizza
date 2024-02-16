package com.pizzaTest.demo.domain;

import jakarta.persistence.Entity;
<<<<<<< HEAD
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resultId;

=======
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Result {
    @Id
    private Long id;
>>>>>>> 7d39abeaca2303565317fc99db785cb459ef13b3
    private String resultTitle;
    private String resultSubTitle;
    private String resultDescription;

<<<<<<< HEAD
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getResultTitle() {
        return resultTitle;
    }

    public void setResultTitle(String resultTitle) {
        this.resultTitle = resultTitle;
    }

    public String getResultSubTitle() {
        return resultSubTitle;
    }

    public void setResultSubTitle(String resultSubTitle) {
        this.resultSubTitle = resultSubTitle;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
=======
    public Result(String resultTitle, String resultSubTitle, String resultDescription) {
        this.resultTitle = resultTitle;
        this.resultSubTitle = resultSubTitle;
>>>>>>> 7d39abeaca2303565317fc99db785cb459ef13b3
        this.resultDescription = resultDescription;
    }
}
