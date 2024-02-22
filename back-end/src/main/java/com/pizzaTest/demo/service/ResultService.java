package com.pizzaTest.demo.service;

import com.pizzaTest.demo.domain.Member;
import com.pizzaTest.demo.domain.Result;
import com.pizzaTest.demo.dto.ResultRequestDto;
import com.pizzaTest.demo.dto.ResultResponseDto;
import com.pizzaTest.demo.dto.UuidResponseDto;
import com.pizzaTest.demo.repository.MBTI;
import com.pizzaTest.demo.repository.MemberRepository;
import com.pizzaTest.demo.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private MemberRepository memberRepository;

    // MBTI 설문지로 MBTI 계산
    public ResultResponseDto CalulateMBTI(ResultRequestDto resultRequestDto, String uuid){

        memberRepository.findByUuid(uuid).orElseThrow(
                ()-> new IllegalArgumentException("invalid uuid")
        );

//        List<Integer> selectQuestion = resultRequestDto.getSelectQuestion();
        int[] selectQuestion = resultRequestDto.getSelectQuestion();
        int[] calculateNumber = new int[4];
        MBTI userMbti = null;

        for(int i=0; i<4; i++) {
//            calculateNumber[i] = selectQuestion.get(3 * i) + selectQuestion.get(3 * i + 1) + selectQuestion.get(3 * i + 2);
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


        Result result = resultRepository.findByMbti(userMbti).orElseThrow(
                ()-> new IllegalArgumentException("자료없음")
        );

        return ResultResponseDto.builder()
                .mbti(result.getMbti())
                .resultDescription(result.getResultDescription())
                .resultTitle(result.getResultTitle())
                .resultSubTitle(result.getResultSubTitle())
                .build();
//
//        Result result = Result.builder()
//                        .selectQuestion(selectQuestion) // 저장해둘 필요가 있나??
//                        .mbti(userMbti)
//                        .build();
//


//        this.resultTitle = resultTitle;
//        this.resultSubTitle = resultSubTitle;
//        this.resultDescription = resultDescription;
//        this.selectQuestion = selectQuestion;
//        this.uuid = uuid;
//        this.MBTI = MBTI;
//        resultRepository.save(result);

    }

//    public ResultResponseDto readResult(String uuid) {
//
//        resultRepository.findById(uuid);
//
//
////        ResultResponseDto resultResponseDto = new ResultResponseDto(resultTitle,resultSubTitle,resultDescription);
////        Result result = Result.builder()
////                .resultTitle(resultTitle)
////                .resultSubTitle(resultSubTitle)
////                .resultDescription(resultDescription)
////                .build();
//
//
//        return resultResponseDto;
//    }
//

}
