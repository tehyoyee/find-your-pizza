package com.pizzaTest.demo.controller;

import com.pizzaTest.demo.dto.ResultResponseDto;
import com.pizzaTest.demo.service.ResultService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ResultController {
    @Autowired
    private ResultService resultService;

    // 설문 결과 요청 - 결과지 저장 및 반환

    @GetMapping("/result")
    public ResultResponseDto RequestResult(HttpServletRequest request) throws BadRequestException {

        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            throw new BadRequestException("No cookie found in the request.");
        }

        String uuid = cookies[0].getValue();

        return resultService.sendResult(uuid);
    }
}

// 통계 추가예정