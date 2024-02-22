package com.pizzaTest.demo.controller;


import com.pizzaTest.demo.dto.SurveyResponseDto;
import com.pizzaTest.demo.service.ServeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/question")
//@RequiredArgsConstructor
public class ServeyController{

    @Autowired
    private ServeyService serveyService;

    // 설문지 보내기(조회요청)
    @GetMapping("/question") // get?
    public List<SurveyResponseDto> sendServey() {
        return serveyService.sendSurvey();
    }

//    // 설문응답지 받기
//    @GetMapping("/question/{uuid}")
//    public void ReadServey(@PathVariable("uuid") @RequestBody Long id){
//
//    }


}