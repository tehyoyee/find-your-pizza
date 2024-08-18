package com.pizzaTest.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pizzaTest.demo.domain.Member;
import com.pizzaTest.demo.domain.Result;
import com.pizzaTest.demo.dto.ResultResponseDto;
import com.pizzaTest.demo.repository.MBTI;
import com.pizzaTest.demo.repository.MemberRepository;
import com.pizzaTest.demo.repository.ResultRepository;

@SpringBootTest
class ResultServiceTest {

	@Autowired
	ResultService resultService;

	@Autowired
	ResultRepository resultRepository;

	@Autowired
	MemberRepository memberRepository;

	@AfterEach
	void tearDown() {
		resultRepository.deleteAll();
		memberRepository.deleteAll();
	}

	@Test
	@DisplayName("MBTI 계산 테스트")
	void calculateMbtiTest() throws BadRequestException {
		//given
		int[] selectQuestion = {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1};
		String uuid = "test-uuid";

		Member member = new Member(uuid);
		memberRepository.save(member);

		//when
		resultService.CalulateMBTI(selectQuestion, uuid);

		//then
		Member updatedMember = memberRepository.findByUuid(uuid).orElseThrow();
		assertEquals(MBTI.ENTJ, updatedMember.getMbti());
	}

	@Test
	@DisplayName("결과지 전송 테스트")
	void sendResultTest() throws BadRequestException {
		// given
		String uuid = "test-uuid";
		MBTI mbti = MBTI.INTP;

		Member member = new Member(uuid);
		member.updateMbti(mbti);
		memberRepository.save(member);

		Result result = Result.builder()
			.mbti(mbti)
			.resultDescription("INTP Description")
			.resultTitle("INTP Title")
			.resultSubTitle("INTP SubTitle")
			.build();

		resultRepository.save(result);

		//when
		ResultResponseDto resultResponseDto = resultService.sendResult(uuid);

		//then
		assertEquals(mbti, resultResponseDto.getMbti());
		assertEquals("INTP Description", resultResponseDto.getResultDescription());
		assertEquals("INTP Title", resultResponseDto.getResultTitle());
		assertEquals("INTP SubTitle", resultResponseDto.getResultSubTitle());
	}

}