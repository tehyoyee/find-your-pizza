package com.pizzaTest.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import com.pizzaTest.domain.Servey;

@RestController
public class ServeyController{


    // 설문지 조회
    @GetMapping("/question/{uuid}")
    public void ReadServey(@RequestBody  UUID uuid){

    }

    // 설문 결과 요청
    @PutMapping("/result")
    public void RequestResult(UUID uuid){

    }

    // 결과 조희
    @GetMapping("/result")
    public void GetResult(UUID uuid){

    }
}