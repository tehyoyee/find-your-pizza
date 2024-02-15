package com.pizzaTest.demo.controller;

import com.pizzaTest.demo.dto.UuidResponseDto;
import com.pizzaTest.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/uuid")
    public UuidResponseDto createMember() {
        return memberService.createUuid();
    }

}
