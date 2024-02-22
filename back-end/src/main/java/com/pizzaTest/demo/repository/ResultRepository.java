package com.pizzaTest.demo.repository;

import com.pizzaTest.demo.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Long> {

//    Result save(Result result);
//    Result findById(int resultId);
    Optional<Result> findById(Long id);

    // MBTI 찾는걸 넣어야하나?
    Optional<Result> findByMbti(MBTI mbti);
}
