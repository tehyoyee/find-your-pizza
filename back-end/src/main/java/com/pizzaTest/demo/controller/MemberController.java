<<<<<<< HEAD
//package com.pizzaTest.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.List;
//
//@Controller
//public class MemberController {
//    private final MemberService memberService;
//
//    @Autowired // 스프링 컨터이너에 등록된 멤버서비스 객체와 연결
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
//
//    // 회원 웹 기능 - 등록
//    @GetMapping("/members/new")
//    public String createForm(){
//
//    }
//
//    @PostMapping("/members/new")
//    public String create(MemberForm form) {
//
//    }
//
//    // 회원 웹 기능 - 조회
//    @GetMapping("/members")
//    public String list(Model model){
//
//    }
//}
=======
package com.pizzaTest.demo.controller;

import com.pizzaTest.demo.dto.UuidResponseDto;
import com.pizzaTest.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/uuid")
    public UuidResponseDto createMember() {
        return memberService.createUuid();
    }

}
>>>>>>> 7d39abeaca2303565317fc99db785cb459ef13b3
