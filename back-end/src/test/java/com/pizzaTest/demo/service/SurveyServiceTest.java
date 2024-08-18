package com.pizzaTest.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pizzaTest.demo.domain.Survey;
import com.pizzaTest.demo.dto.SurveyResponseDto;
import com.pizzaTest.demo.repository.SurveyRepository;

@SpringBootTest
class SurveyServiceTest {

	@Autowired
	SurveyService surveyService;

	@Autowired
	SurveyRepository surveyRepository;

	@AfterEach
	void tearDown() {
		surveyRepository.deleteAll();
	}

	@Test
	@DisplayName("설문지 전송 테스트")
	void sendSurveyTest() {
		// given
		Survey survey1 = Survey.builder()
			.firstQuestion("Question 1A")
			.secondQuestion("Question 1B")
			.questionTitle("Title 1")
			.build();

		Survey survey2 = Survey.builder()
			.firstQuestion("Question 2A")
			.secondQuestion("Question 2B")
			.questionTitle("Title 2")
			.build();

		surveyRepository.save(survey1);
		surveyRepository.save(survey2);

		// when
		List<SurveyResponseDto> result = surveyService.sendSurvey();

		// then
		assertEquals(2, result.size());
		assertEquals("Question 1A", result.get(0).getFirstQuestion());
		assertEquals("Question 2A", result.get(1).getFirstQuestion());
	}

}