package com.pizzaTest.demo.service;

import com.pizzaTest.demo.domain.Member;
<<<<<<< HEAD

public class MemberService{
    private final Member member = new Member();
}
=======
import com.pizzaTest.demo.dto.UuidResponseDto;
import com.pizzaTest.demo.repository.member.MemberRepository;
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
>>>>>>> 7d39abeaca2303565317fc99db785cb459ef13b3
