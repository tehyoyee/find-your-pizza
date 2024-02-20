package com.pizzaTest.demo.service;

import com.pizzaTest.demo.domain.Servey;
import com.pizzaTest.demo.dto.QuestionRequestDto;
import com.pizzaTest.demo.dto.QuestionResponseDto;
import com.pizzaTest.demo.repository.MBTI;
import com.pizzaTest.demo.repository.ServeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ServeyService{

    @Autowired
    private ServeyRepository serveyRepository;

    public QuestionResponseDto sendQuestion(){

        //Question 불러드려서 한 번에 보내기 어떻게?
        // 일단 하드코딩으로 보내기

        String questionTitle="Title";
        String firstQuestion="question1";
        String secondQuestion="question2";

        QuestionResponseDto questionResponseDto =
                new QuestionResponseDto(questionTitle,firstQuestion,secondQuestion);

        Servey servey = Servey.builder()
                .questionTitle(questionTitle)
                .firstQuestion(firstQuestion)
                .secondQuestion(secondQuestion)
                .build();

        serveyRepository.save(servey); // 저장해둘 필요가 있나??

        return questionResponseDto;
    }



}