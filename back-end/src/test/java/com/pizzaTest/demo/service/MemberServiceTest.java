package com.pizzaTest.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pizzaTest.demo.dto.UuidResponseDto;
import com.pizzaTest.demo.repository.MemberRepository;

@SpringBootTest
class MemberServiceTest {
	@Autowired
	MemberService memberService;

	@Autowired
	MemberRepository memberRepository;

	@AfterEach
	void tearDown() {
		memberRepository.deleteAll();
	}

	@DisplayName("UUID 생성 테스트")
	@Test
	void createUuidTest() {
		//given
		//when
		UuidResponseDto uuid = memberService.createUuid();

		//then
		assertNotNull(uuid.getUuid());
		assertFalse(uuid.getUuid().isEmpty());
	}
}