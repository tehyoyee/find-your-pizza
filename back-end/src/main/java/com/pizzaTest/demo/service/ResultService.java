package com.pizzaTest.demo.service;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzaTest.demo.domain.Member;
import com.pizzaTest.demo.domain.Result;
import com.pizzaTest.demo.dto.ResultResponseDto;
import com.pizzaTest.demo.repository.MBTI;
import com.pizzaTest.demo.repository.MemberRepository;
import com.pizzaTest.demo.repository.ResultRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ResultService {

    // 저장용 repository
    private final ResultRepository resultRepository;

    // UUID 확인용(갖고있는 UUID와 프론트에서 보내준 UUID가 같은지 확인)
    private final MemberRepository memberRepository;

    // MBTI 설문지로 MBTI 계산
    @Transactional // Entity 수정하겠다. (= DB수정)
    public void CalulateMBTI(int[] selectQuestion, String uuid) throws BadRequestException {

        // uuid 확인
        validateUuid(uuid);

        // 선택한 설문지 12개인지 확인 + 선택한 설문지 값이 0 or 1인지 확인
        validateQuestion(selectQuestion);

        // 선택한 설문지
        MBTI userMbti = getMbtiSb(selectQuestion);

        // DB수정 -> @Transactional가 있으면 변경된 것을 관찰해서 변경시켜준다.
        Member member = getMemberByUuid(uuid);

        member.updateMbti(userMbti);
    }

    public ResultResponseDto sendResult(String uuid) throws BadRequestException {
        Member member = getMemberByUuid(uuid);

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

    private Member getMemberByUuid(String uuid) throws BadRequestException {
        return memberRepository.findByUuid(uuid).orElseThrow(
            () -> new BadRequestException("uuid is not found")
        );
    }

    private static MBTI getMbtiSb(int[] selectQuestion) {
        int[] calculateNumber = new int[4];

        for (int i = 0; i < 4; i++) {
            calculateNumber[i] = selectQuestion[3 * i] + selectQuestion[3 * i + 1] + selectQuestion[3 * i + 2];
        }
        StringBuilder mbtiSb = new StringBuilder();

        mbtiSb.append(calculateNumber[0] > 1 ? "I" : "E");
        mbtiSb.append(calculateNumber[1] > 1 ? "N" : "S");
        mbtiSb.append(calculateNumber[2] > 1 ? "F" : "T");
        mbtiSb.append(calculateNumber[3] > 1 ? "J" : "P");

        return MBTI.valueOf(mbtiSb.toString());
    }

    private static void validateQuestion(int[] selectQuestion) throws BadRequestException {
        if(selectQuestion.length != 12){
            throw new BadRequestException("invalid question quantity");
        }

		for (int j : selectQuestion) {
			if (j > 1 || j < 0) {
				throw new BadRequestException("invalid question result");
			}
		}
    }

    private void validateUuid(String uuid) throws BadRequestException {
        memberRepository.findByUuid(uuid).orElseThrow(
            () -> new BadRequestException("invalid uuid")
            //최이지 코치님 줌 들어와서 말씀하신 에러응답모델 참고 필요
        );
    }
}