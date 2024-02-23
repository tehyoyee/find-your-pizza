package com.pizzaTest.demo.controller;

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
}