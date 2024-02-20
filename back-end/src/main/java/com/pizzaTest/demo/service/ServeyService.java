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


    // MBTI 설문지로 MBTI 계산
    public QuestionRequestDto CalulateMBTI(int[] selectQuestion){

        int[] calculateNumber = new int[4];
        MBTI userMbti = null;

        for(int i=0; i<4; i++) {
            calculateNumber[i] = selectQuestion[3 * i] + selectQuestion[3 * i + 1] + selectQuestion[3 * i + 2];
        }
            if (calculateNumber[0] > 1 && calculateNumber[1] > 1 && calculateNumber[2] > 1 && calculateNumber[3] > 1){
                userMbti = MBTI.INFJ;
            }else if(calculateNumber[0] > 1 && calculateNumber[1] > 1 && calculateNumber[2] > 1 && calculateNumber[3] < 1){
                userMbti = MBTI.INFP;
            }else if(calculateNumber[0] > 1 && calculateNumber[1] > 1 && calculateNumber[2] < 1 && calculateNumber[3] > 1){
                userMbti = MBTI.INTJ;
            }else if(calculateNumber[0] > 1 && calculateNumber[1] > 1 && calculateNumber[2] < 1 && calculateNumber[3] < 1){
                userMbti = MBTI.INTP;
            }else if(calculateNumber[0] > 1 && calculateNumber[1] < 1 && calculateNumber[2] > 1 && calculateNumber[3] > 1){
                userMbti = MBTI.ISFJ;
            }else if(calculateNumber[0] > 1 && calculateNumber[1] < 1 && calculateNumber[2] > 1 && calculateNumber[3] < 1){
                userMbti = MBTI.ISFP;
            }else if(calculateNumber[0] > 1 && calculateNumber[1] < 1 && calculateNumber[2] < 1 && calculateNumber[3] < 1){
                userMbti = MBTI.ISTJ;
            }else if(calculateNumber[0] > 1 && calculateNumber[1] < 1 && calculateNumber[2] < 1 && calculateNumber[3] > 1){
                userMbti = MBTI.ISTP;
            }else if(calculateNumber[0] < 1 && calculateNumber[1] > 1 && calculateNumber[2] > 1 && calculateNumber[3] > 1){
                userMbti = MBTI.ENFJ;
            }else if(calculateNumber[0] < 1 && calculateNumber[1] > 1 && calculateNumber[2] > 1 && calculateNumber[3] < 1){
                userMbti = MBTI.ENFP;
            }else if(calculateNumber[0] < 1 && calculateNumber[1] > 1 && calculateNumber[2] < 1 && calculateNumber[3] > 1){
                userMbti = MBTI.ENTJ;
            }else if(calculateNumber[0] < 1 && calculateNumber[1] < 1 && calculateNumber[2] > 1 && calculateNumber[3] > 1){
                userMbti = MBTI.ESFJ;
            }else if(calculateNumber[0] < 1 && calculateNumber[1] < 1 && calculateNumber[2] < 1 && calculateNumber[3] > 1){
                userMbti = MBTI.ESTJ;
            }else if(calculateNumber[0] < 1 && calculateNumber[1] < 1 && calculateNumber[2] > 1 && calculateNumber[3] < 1){
                userMbti = MBTI.ESFP;
            }else if(calculateNumber[0] < 1 && calculateNumber[1] < 1 && calculateNumber[2] < 1 && calculateNumber[3] < 1){
                userMbti = MBTI.ESTP;
            }else {
                userMbti = MBTI.ENTP;
            }



        QuestionRequestDto questionRequestDto =
                new QuestionRequestDto(selectQuestion, userMbti.name());

        Servey servey = Servey.builder()
                .selectQuestion(selectQuestion)
                .MBTI(String.valueOf(userMbti))
                .build();

        serveyRepository.save(servey); // 저장해둘 필요가 있나??

        return questionRequestDto;

    }
}