package com.pizzaTest.demo.controller;

import com.pizzaTest.demo.dto.AnswersRequest.AnswersRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaTest.demo.dto.SurveyResponseDto;
import com.pizzaTest.demo.service.ServeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServeyController{
    @Autowired
    private ServeyService serveyService;

    // 설문지 보내기(조회요청)
    @GetMapping("/question")
    public List<SurveyResponseDto> sendServey() {
        return serveyService.sendSurvey();
    }

    @PostMapping("/question")
    public void receiveAnswersAndCookie(@RequestBody AnswersRequest answersRequest, HttpServletRequest request) {
        // 받은 answers 배열 출력
        String[] answers = answersRequest.getAnswers();
        for (String answer : answers) {
            System.out.println("Answer: " + answer);
        }

        // 쿠키 출력
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("Cookie Name: " + cookie.getName() + ", Value: " + cookie.getValue());
            }
        }
    }
}