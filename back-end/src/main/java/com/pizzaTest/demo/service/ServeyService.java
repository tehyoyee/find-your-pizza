package com.pizzaTest.demo.service;

import com.pizzaTest.demo.domain.Servey;
import com.pizzaTest.demo.dto.SurveyResponseDto;
import com.pizzaTest.demo.repository.ServeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServeyService{

    @Autowired
    private ServeyRepository serveyRepository;

    public List<SurveyResponseDto> sendSurvey(){
        List<Servey> serveyList = serveyRepository.findAll();

        List<SurveyResponseDto> dtoList = new ArrayList<>();
        for (Servey x : serveyList) {
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