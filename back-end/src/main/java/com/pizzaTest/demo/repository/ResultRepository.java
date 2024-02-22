package com.pizzaTest.demo.repository;

import com.pizzaTest.demo.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Long> {
    // ID로 결과지 찾기
    Optional<Result> findById(Long id);

    // MBTI로 결과지 찾기
    Optional<Result> findByMbti(MBTI mbti);
}
