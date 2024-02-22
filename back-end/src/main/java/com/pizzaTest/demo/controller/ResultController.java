package com.pizzaTest.demo.controller;

import com.pizzaTest.demo.dto.ResultRequestDto;
import com.pizzaTest.demo.dto.ResultResponseDto;
import com.pizzaTest.demo.service.ResultService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {
    @Autowired
    private ResultService resultService;

    // 설문 결과 요청 - 결과지 저장 및 반환
    @PostMapping("/result")
    public ResultResponseDto RequestResult(@RequestBody ResultRequestDto resultRequestDto, HttpServletRequest request) throws BadRequestException {
        String uuid = request.getHeader("uuid");
        System.out.println(resultRequestDto.getSelectQuestion()[0]);
        return resultService.CalulateMBTI(resultRequestDto, uuid);
    }
}