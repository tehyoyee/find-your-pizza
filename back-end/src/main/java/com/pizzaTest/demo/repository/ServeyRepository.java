package com.pizzaTest.demo.repository;

import com.pizzaTest.demo.domain.Servey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ServeyRepository extends JpaRepository<Servey, Long> {
    // ID로 설문지 찾기
    Optional<Servey> findById(Long id);
}
