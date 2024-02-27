package com.pizzaTest.demo.controller;


import com.pizzaTest.demo.dto.ResultRequestDto;
import com.pizzaTest.demo.service.ResultService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaTest.demo.dto.SurveyResponseDto;
import com.pizzaTest.demo.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @Autowired
    private ResultService resultService;

    // 설문지 보내기(조회요청)
    @GetMapping("/question")
    public List<SurveyResponseDto> sendSurvey() {
        return surveyService.sendSurvey();
    }

    @PostMapping("/question")
    public void receiveAnswersAndCookie(@RequestBody ResultRequestDto answersRequest, HttpServletRequest request) throws BadRequestException {
        // 쿠키 출력
        Cookie[] cookies = request.getCookies();
        String uuid = cookies[0].getValue();

        // 받은 answers 배열 출력
        int[] parsedResult =  Arrays.stream(answersRequest.getAnswers()).mapToInt(Integer::parseInt).toArray();

        resultService.CalulateMBTI(parsedResult, uuid);
    }
}