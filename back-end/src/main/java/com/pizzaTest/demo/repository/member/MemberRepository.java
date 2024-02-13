package com.pizzaTest.demo.repository.member;

import com.pizzaTest.demo.domain.Member;

import java.util.List;

public interface MemberRepository {
    // 회원 저장
    Member save(Member member);

    // 회원 찾기
    Member findById(int userId);
    List<Member> findAll();
}
