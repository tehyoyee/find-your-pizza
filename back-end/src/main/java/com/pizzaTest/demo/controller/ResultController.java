package com.pizzaTest.demo.controller;

import com.pizzaTest.demo.dto.ResultRequestDto;
import com.pizzaTest.demo.dto.ResultResponseDto;
import com.pizzaTest.demo.service.ResultService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/result")
//@RequiredArgsConstructor
public class ResultController {

    @Autowired
    private ResultService resultService;

    // 설문 결과 요청 ---- 결과지 저장 및 반환
    @PostMapping("/result")
    public ResultResponseDto RequestResult(@RequestBody ResultRequestDto resultRequestDto, HttpServletRequest request){
        String uuid = request.getHeader("uuid");
        return resultService.CalulateMBTI(resultRequestDto, uuid);
//        return resultService.readResult(uuid);
    }

//    결과지 주세요 -> 계산해서 무슨 mbti 인지 -> 그걸 디비에서 꺼내오죠 -> 리턴.
//            통계를 위해서 : 어디다가 ??

    // 결과 조희
    // HttpServletRequest request : 리퀘스트... 통째로?
//    @GetMapping("/result")
//    public ResultResponseDto GetResult(HttpServletRequest request){
//        return resultService.readResult(uuid);
//    }

}