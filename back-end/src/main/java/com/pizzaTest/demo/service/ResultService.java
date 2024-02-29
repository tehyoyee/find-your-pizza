package com.pizzaTest.demo.service;

import com.pizzaTest.demo.domain.Member;
import com.pizzaTest.demo.domain.Result;
import com.pizzaTest.demo.dto.ResultRequestDto;
import com.pizzaTest.demo.dto.ResultResponseDto;
import com.pizzaTest.demo.repository.MBTI;
import com.pizzaTest.demo.repository.MemberRepository;
import com.pizzaTest.demo.repository.ResultRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ResultService {

    // 저장용 repository
    @Autowired
    private ResultRepository resultRepository;

    // UUID 확인용(갖고있는 UUID와 프론트에서 보내준 UUID가 같은지 확인)
    @Autowired
    private MemberRepository memberRepository;

    // MBTI 설문지로 MBTI 계산
    @Transactional // Entity 수정하겠다. (= DB수정)
    public void CalulateMBTI(int[] selectQuestion, String uuid) throws BadRequestException {
        memberRepository.findByUuid(uuid).orElseThrow(
                () -> new BadRequestException("invalid uuid")
                //최이지 코치님 줌 들어와서 말씀하신 에러응답모델 참고 필요
        );

        // 선택한 설문지
        int[] calculateNumber = new int[4];
        MBTI userMbti = null;

        // 설문지 0,1 중 선택
        // 0 : E S T P
        // 1 : I N F J
        for (int i = 0; i < 4; i++) {
            calculateNumber[i] = selectQuestion[3 * i] + selectQuestion[3 * i + 1] + selectQuestion[3 * i + 2];
        }
        if (calculateNumber[0] > 1 && calculateNumber[1] > 1 && calculateNumber[2] > 1 && calculateNumber[3] > 1) {
            userMbti = MBTI.INFJ;
        } else if (calculateNumber[0] > 1 && calculateNumber[1] > 1 && calculateNumber[2] > 1 && calculateNumber[3] < 1) {
            userMbti = MBTI.INFP;
        } else if (calculateNumber[0] > 1 && calculateNumber[1] > 1 && calculateNumber[2] < 1 && calculateNumber[3] > 1) {
            userMbti = MBTI.INTJ;
        } else if (calculateNumber[0] > 1 && calculateNumber[1] > 1 && calculateNumber[2] < 1 && calculateNumber[3] < 1) {
            userMbti = MBTI.INTP;
        } else if (calculateNumber[0] > 1 && calculateNumber[1] < 1 && calculateNumber[2] > 1 && calculateNumber[3] > 1) {
            userMbti = MBTI.ISFJ;
        } else if (calculateNumber[0] > 1 && calculateNumber[1] < 1 && calculateNumber[2] > 1 && calculateNumber[3] < 1) {
            userMbti = MBTI.ISFP;
        } else if (calculateNumber[0] > 1 && calculateNumber[1] < 1 && calculateNumber[2] < 1 && calculateNumber[3] < 1) {
            userMbti = MBTI.ISTJ;
        } else if (calculateNumber[0] > 1 && calculateNumber[1] < 1 && calculateNumber[2] < 1 && calculateNumber[3] > 1) {
            userMbti = MBTI.ISTP;
        } else if (calculateNumber[0] < 1 && calculateNumber[1] > 1 && calculateNumber[2] > 1 && calculateNumber[3] > 1) {
            userMbti = MBTI.ENFJ;
        } else if (calculateNumber[0] < 1 && calculateNumber[1] > 1 && calculateNumber[2] > 1 && calculateNumber[3] < 1) {
            userMbti = MBTI.ENFP;
        } else if (calculateNumber[0] < 1 && calculateNumber[1] > 1 && calculateNumber[2] < 1 && calculateNumber[3] > 1) {
            userMbti = MBTI.ENTJ;
        } else if (calculateNumber[0] < 1 && calculateNumber[1] < 1 && calculateNumber[2] > 1 && calculateNumber[3] > 1) {
            userMbti = MBTI.ESFJ;
        } else if (calculateNumber[0] < 1 && calculateNumber[1] < 1 && calculateNumber[2] < 1 && calculateNumber[3] > 1) {
            userMbti = MBTI.ESTJ;
        } else if (calculateNumber[0] < 1 && calculateNumber[1] < 1 && calculateNumber[2] > 1 && calculateNumber[3] < 1) {
            userMbti = MBTI.ESFP;
        } else if (calculateNumber[0] < 1 && calculateNumber[1] < 1 && calculateNumber[2] < 1 && calculateNumber[3] < 1) {
            userMbti = MBTI.ESTP;
        } else {
            userMbti = MBTI.ENTP;
        }

        // DB수정 -> @Transactional가 있으면 변경된 것을 관찰해서 변경시켜준다.
        Member member = memberRepository.findByUuid(uuid).orElseThrow(
                () -> new BadRequestException("d")
        );

        member.setMbti(userMbti);
    }

    public ResultResponseDto sendResult(String uuid) throws BadRequestException {
        Member member = memberRepository.findByUuid(uuid).orElseThrow(
                () -> new BadRequestException("uuid 없음")
        );

        System.out.println(member.getId());
        System.out.println(member.getMbti());

        MBTI mbti = member.getMbti();

        // 계산된 mbti에 해당하는 결과값 추출, 없으면 에러
        Result result = resultRepository.findByMbti(mbti).orElseThrow(
                () -> new BadRequestException("자료없음")
        );

        // Dto에 mbti와 설명글 저장 후 return
        return ResultResponseDto.builder()
                .mbti(result.getMbti())
                .resultDescription(result.getResultDescription())
                .resultTitle(result.getResultTitle())
                .resultSubTitle(result.getResultSubTitle())
                .build();
    }

}