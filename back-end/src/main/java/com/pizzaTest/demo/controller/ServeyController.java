package com.pizzaTest.demo.controller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
=======
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class ServeyController{

    @GetMapping("/{questionId}")
    public void sendForm(@PathVariable("questionId") int questionId, Model model) {
>>>>>>> 7d39abeaca2303565317fc99db785cb459ef13b3

    }
}