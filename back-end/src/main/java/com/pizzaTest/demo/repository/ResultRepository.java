package com.pizzaTest.demo.repository;

import com.pizzaTest.demo.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {

//    Result save(Result result);
//    Result findById(int resultId);

}
