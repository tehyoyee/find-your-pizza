package com.pizzaTest.demo.repository;

import com.pizzaTest.demo.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    // ID로 설문지 찾기
    Optional<Survey> findById(Long id);
}
