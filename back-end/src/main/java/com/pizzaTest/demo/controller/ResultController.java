package com.pizzaTest.demo.controller;

import com.pizzaTest.demo.dto.ResultRequestDto;
import com.pizzaTest.demo.dto.ResultResponseDto;
import com.pizzaTest.demo.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/result")
//@RequiredArgsConstructor
public class ResultController {

    @Autowired
    private ResultService resultService;

    // 설문 결과 요청
    @PostMapping("/result")
    public ResultRequestDto RequestResult(Long id){
        // selectQuestion이 들어가야하는 것 같은데 어떻게 써야함??
        // 일단 하드코딩
        int[] a = new int[12];
        return resultService.CalulateMBTI(a);
    }

    // 결과 조희
    @GetMapping("/result")
    public ResultResponseDto GetResult(Long id){
        return resultService.readResult();
    }

}