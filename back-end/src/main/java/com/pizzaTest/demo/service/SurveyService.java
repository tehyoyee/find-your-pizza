package com.pizzaTest.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pizzaTest.demo.domain.Survey;
import com.pizzaTest.demo.dto.SurveyResponseDto;
import com.pizzaTest.demo.repository.SurveyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

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

        return dtoList;
    }
}