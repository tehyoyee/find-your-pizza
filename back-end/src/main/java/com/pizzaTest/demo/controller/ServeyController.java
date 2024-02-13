package com.pizzaTest.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class ServeyController{

    @GetMapping("/{questionId}}")
    public void sendForm(@PathVariable("questionId") int questionId, Model model) {

    }
}