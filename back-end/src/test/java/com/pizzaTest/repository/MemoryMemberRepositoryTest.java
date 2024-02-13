package com.pizzaTest.repository;

import com.pizzaTest.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearMember();
    }

    @Test
    void save() {
        Member member1 = new Member();
        Member member2 = new Member();

        repository.save(member1);
        repository.save(member2);

        assertThat(member1).isNotSameAs(member2);
    }

    @Test
    void findById() {
        Member member = new Member();

        repository.save(member);

        Member findResult = repository.findById(member.getUserId());
        assertThat(findResult).isEqualTo(member);
    }

    @Test
    void findAll() {
        Member memberA = new Member();
        Member memberB = new Member();
        Member memberC = new Member();
        Member memberD = new Member();

        repository.save(memberA);
        repository.save(memberB);
        repository.save(memberC);
        repository.save(memberD);

        List<Member> resultList = repository.findAll();
        assertThat(resultList.size()).isEqualTo(4);

        /*
        for(Member member : resultList){
            System.out.println("member.getUserID() = " + member.getUserID());
            System.out.println("member.getUuid() = " + member.getUuid());
        }
         */
    }
}