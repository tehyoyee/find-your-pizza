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

        //UUID 생성

        String uuid = UUID.randomUUID().toString();

        //생성 후 Dto로 만들어서 return
        UuidResponseDto uuidResponseDto = new UuidResponseDto(uuid);

        // repository에 저장
        Member member = Member.builder()
                .uuid(uuid)
                .build();
        memberRepository.save(member);

        return uuidResponseDto;
    }

}
