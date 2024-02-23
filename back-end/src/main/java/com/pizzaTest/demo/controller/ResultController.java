package com.pizzaTest.demo.controller;

import com.pizzaTest.demo.dto.ResultRequestDto;
import com.pizzaTest.demo.dto.ResultResponseDto;
import com.pizzaTest.demo.service.ResultService;
<<<<<<< HEAD
=======
import jakarta.servlet.http.Cookie;
>>>>>>> b24d98226c2c491786038199a3d058d8eb3bda91
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {
    @Autowired
    private ResultService resultService;

    // 설문 결과 요청 - 결과지 저장 및 반환
<<<<<<< HEAD
    @PostMapping("/result")
    public ResultResponseDto RequestResult(@RequestBody ResultRequestDto resultRequestDto, HttpServletRequest request) throws BadRequestException {
        String uuid = request.getHeader("uuid");
        System.out.println(resultRequestDto.getSelectQuestion()[0]);
        return resultService.CalulateMBTI(resultRequestDto, uuid);
    }

    // 통계 추가예정
=======
    @GetMapping("/result")
    public ResultResponseDto RequestResult(HttpServletRequest request) throws BadRequestException {
        System.out.println(" 여기는? ");

        Cookie[] cookies = request.getCookies();
        String uuid = cookies[0].getValue();


        System.out.println(" 여기는 왔니 ? ");

        return resultService.sendResult(uuid);
    }

    // 통계 추가예정

>>>>>>> b24d98226c2c491786038199a3d058d8eb3bda91

}