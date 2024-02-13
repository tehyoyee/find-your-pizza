package com.pizzaTest.repository;

import com.pizzaTest.domain.Member;

import java.util.List;

public interface MemberRepository {
    // 회원 저장
    Member save(Member member);

    // 회원 찾기
    Member findById(Long userId);
    List<Member> findAll();
}
