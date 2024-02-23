package com.pizzaTest.demo.controller;

import com.pizzaTest.demo.dto.ResultRequestDto;
import com.pizzaTest.demo.dto.ResultResponseDto;
import com.pizzaTest.demo.service.ResultService;
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
    public ResultResponseDto RequestResult(ResultRequestDto resultRequestDto, HttpServletRequest request) throws BadRequestException {
        String uuid = request.getHeader("uuid");
//        int[] getSelectQuestion = resultRequestDto.getSelectQuestion();

        log.info(uuid);
        System.out.println(uuid);

        return resultService.CalulateMBTI(resultRequestDto, uuid);
    }

    // 통계 추가예정


}