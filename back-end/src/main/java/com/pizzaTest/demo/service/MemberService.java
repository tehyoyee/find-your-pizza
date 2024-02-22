package com.pizzaTest.demo.service;
import com.pizzaTest.demo.domain.Member;
import com.pizzaTest.demo.dto.UuidResponseDto;
import com.pizzaTest.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public UuidResponseDto createUuid() {
        String uuid = UUID.randomUUID().toString();

        UuidResponseDto uuidResponseDto = new UuidResponseDto(uuid);
        Member member = Member.builder()
                .uuid(uuid)
                .build();

        memberRepository.save(member);
        return uuidResponseDto;
    }

}
