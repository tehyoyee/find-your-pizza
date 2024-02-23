package com.pizzaTest.demo.repository;

import com.pizzaTest.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // ID로 회원 찾기
    Optional<Member> findById(Long id);

    // UUID로 회원 찾기
    Optional<Member> findByUuid(String uuid);

}
