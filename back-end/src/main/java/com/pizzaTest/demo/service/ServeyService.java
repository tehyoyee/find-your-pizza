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

        //Question 불러드려서 한 번에 보내기 어떻게?
        // 일단 하드코딩으로 보내기
        //list ??
//        String questionTitle="Title";
//        String firstQuestion="question1";
//        String secondQuestion="question2";
//        QuestionResponseDto questionResponseDto =
//                new QuestionResponseDto(questionTitle,firstQuestion,secondQuestion);

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



//        serveyRepository.save(servey); // 저장해둘 필요가 있나??

        return dtoList;
    }



}