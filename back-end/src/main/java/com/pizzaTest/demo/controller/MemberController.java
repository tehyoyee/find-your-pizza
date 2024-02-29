package com.pizzaTest.demo.controller;

import com.pizzaTest.demo.dto.UuidResponseDto;
import com.pizzaTest.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/uuid")
    public UuidResponseDto createMember() {
        return memberService.createUuid();
    }
}