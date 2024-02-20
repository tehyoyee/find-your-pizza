package com.pizzaTest.demo.controller;


import com.pizzaTest.demo.dto.QuestionResponseDto;
import com.pizzaTest.demo.service.ServeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/question")
//@RequiredArgsConstructor
public class ServeyController{

    @Autowired
    private ServeyService serveyService;

    // 설문지 보내기(조회요청)
    @PostMapping("/question/{id}") //
    public QuestionResponseDto sendServey(@PathVariable("id") Long id) {
        return serveyService.sendQuestion();
    }

//    // 설문응답지 받기
//    @GetMapping("/question/{uuid}")
//    public void ReadServey(@PathVariable("uuid") @RequestBody Long id){
//
//    }


}