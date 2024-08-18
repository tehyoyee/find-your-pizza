package com.pizzaTest.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaTest.demo.dto.UuidResponseDto;
import com.pizzaTest.demo.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String check() {
        return "awsConnectCheck";
    }

    @GetMapping("/uuid")
    public UuidResponseDto createMember() {
        return memberService.createUuid();
    }
}