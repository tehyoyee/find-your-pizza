package com.pizzaTest.demo.service;

import com.pizzaTest.demo.domain.Result;
import com.pizzaTest.demo.domain.Servey;
import com.pizzaTest.demo.dto.QuestionRequestDto;
import com.pizzaTest.demo.repository.MBTI;
import com.pizzaTest.demo.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ResultService {


    @Autowired
    private ResultRepository resultRepository;
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

        Result result = Result.builder()
                .selectQuestion(selectQuestion) // 저장해둘 필요가 있나??
                .MBTI(String.valueOf(userMbti))
                .build();

        resultRepository.save(result);

        return questionRequestDto;

    }

//    // MBTI 정보 전체 저장
//    public static class MBTIinfo{
//
//        public MBTIinfo(){
//            resultTitle = new HashMap<>();
//            resultSubTitle = new HashMap<>();
//            resultDescription = new HashMap<>();
//
//            // 1. INFJ
//            resultTitle.put("INFJ","");
//            resultSubTitle.put("INFJ","");
//            resultDescription.put("INFJ","");
//            // 2. INFP
//            resultTitle.put("INFP","");
//            resultSubTitle.put("INFP","");
//            resultDescription.put("INFP","");
//            // 3. INTJ
//            resultTitle.put("INTJ","");
//            resultSubTitle.put("INTJ","");
//            resultDescription.put("INTJ","");
//            // 4. INTP
//            resultTitle.put("INTP","");
//            resultSubTitle.put("INTP","");
//            resultDescription.put("INTP","");
//            // 5. ISFJ
//            resultTitle.put("ISFJ","");
//            resultSubTitle.put("ISFJ","");
//            resultDescription.put("ISFJ","");
//            // 6. ISFP
//            resultTitle.put("ISFP","");
//            resultSubTitle.put("ISFP","");
//            resultDescription.put("ISFP","");
//            // 7. ISTJ
//            resultTitle.put("ISTJ","");
//            resultSubTitle.put("ISTJ","");
//            resultDescription.put("ISTJ","");
//            // 8. ISTP
//            resultTitle.put("ISTP","");
//            resultSubTitle.put("ISTP","");
//            resultDescription.put("ISTP","");
//            // 9. ENFJ
//            resultTitle.put("ENFJ","");
//            resultSubTitle.put("ENFJ","");
//            resultDescription.put("ENFJ","");
//            // 10.ENFP
//            resultTitle.put("ENFP","");
//            resultSubTitle.put("ENFP","");
//            resultDescription.put("ENFP","");
//            // 11. ENTJ
//            resultTitle.put("ENTJ","");
//            resultSubTitle.put("ENTJ","");
//            resultDescription.put("ENTJ","");
//            // 12. ESFJ
//            resultTitle.put("ESFJ","");
//            resultSubTitle.put("ESFJ","");
//            resultDescription.put("ESFJ","");
//            // 13. ESTJ
//            resultTitle.put("ESTJ","");
//            resultSubTitle.put("ESTJ","");
//            resultDescription.put("ESTJ","");
//            // 14. ESFP
//            resultTitle.put("ESFP","");
//            resultSubTitle.put("ESFP","");
//            resultDescription.put("ESFP","");
//            // 15. ESTP
//            resultTitle.put("ESTP","");
//            resultSubTitle.put("ESTP","");
//            resultDescription.put("ESTP","");
//            // 16. ENTP
//            resultTitle.put("ENTP","");
//            resultSubTitle.put("ENTP","");
//            resultDescription.put("ENTP","");
//        }
//
//
//        public String getResultTitle(MBTI mbti){
//            return resultTitle.get(String.valueOf(mbti));
//        }
//        public String getResultSubTitle(MBTI mbti){
//            return resultSubTitle.get(String.valueOf(mbti));
//        }
//        public String getResultDescription(MBTI mbti){
//            return resultDescription.get(String.valueOf(mbti));
//        }
//
//
//    }
}
