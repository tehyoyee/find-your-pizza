package com.pizzaTest.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD

=======
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
>>>>>>> 7d39abeaca2303565317fc99db785cb459ef13b3
@Entity
public class Servey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private int questionId;
=======
    private Long id;
>>>>>>> 7d39abeaca2303565317fc99db785cb459ef13b3

    private String questionTitle;
    private String firstQuestion;
    private String secondQuestion;

<<<<<<< HEAD
    private int[] selectQuestion = new int[12];

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String title) {
        this.questionTitle = questionTitle;
    }

    public String getFirstQuestion() {
        return firstQuestion;
    }

    public void setFirstQuestion(String firstQuestion) {
        this.firstQuestion = firstQuestion;
    }

    public String getSecondQuestion() {
        return secondQuestion;
    }

    public void setSecondQuestion(String secondQuestion) {
        this.secondQuestion = secondQuestion;
    }

    public int[] getSelectQuestion() { return selectQuestion;}

    public void setSelectQuestion(int[] selectQuestion){this.selectQuestion=selectQuestion;}

}
=======
    public Servey(String questionTitle, String firstQuestion, String secondQuestion) {
        this.questionTitle = questionTitle;
        this.firstQuestion = firstQuestion;
        this.secondQuestion = secondQuestion;
    }
}
>>>>>>> 7d39abeaca2303565317fc99db785cb459ef13b3
