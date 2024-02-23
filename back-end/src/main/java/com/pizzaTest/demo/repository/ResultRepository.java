package com.pizzaTest.demo.repository;

import com.pizzaTest.demo.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Long> {


    Optional<Result> findById(Long id);

    Optional<Result> findByMbti(MBTI mbti);
}
