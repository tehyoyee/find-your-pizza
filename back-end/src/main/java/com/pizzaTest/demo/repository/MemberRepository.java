package com.pizzaTest.demo.repository;

import com.pizzaTest.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 회원 저장
//    Member save(Member member);

    // 회원 찾기
    Optional<Member> findById(Long id);

//    List<Member> findAll();
}
