package com.pizzaTest.demo.service;

import com.pizzaTest.demo.domain.Survey;
import com.pizzaTest.demo.dto.SurveyResponseDto;
import com.pizzaTest.demo.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public List<SurveyResponseDto> sendSurvey(){

        // repository에 있는 설문지 전부 꺼내오기
        List<Survey> surveyList = surveyRepository.findAll();


        List<SurveyResponseDto> dtoList = new ArrayList<>();

        // 설문지 전부 List형태의 dto에 저장하고 return
        for (Survey x : surveyList) {
            dtoList.add(SurveyResponseDto.builder()
                    .firstQuestion(x.getFirstQuestion())
                    .secondQuestion(x.getSecondQuestion())
                    .id(x.getId())
                    .questionTitle(x.getQuestionTitle())
                    .build());
        }


        System.out.println("dtoList.get(0).getFirstQuestion() = " + dtoList.get(0).getFirstQuestion());
        return dtoList;
    }


}