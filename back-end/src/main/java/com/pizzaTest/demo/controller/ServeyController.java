package com.pizzaTest.demo.controller;

<<<<<<< HEAD
=======
import com.pizzaTest.demo.dto.AnswersRequest.AnswersRequest;
import com.pizzaTest.demo.dto.ResultRequestDto;
import com.pizzaTest.demo.service.ResultService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> b24d98226c2c491786038199a3d058d8eb3bda91
import com.pizzaTest.demo.dto.SurveyResponseDto;
import com.pizzaTest.demo.service.ServeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
=======
import java.util.Arrays;
>>>>>>> b24d98226c2c491786038199a3d058d8eb3bda91
import java.util.List;

@RestController
public class ServeyController{
    @Autowired
    private ServeyService serveyService;

    @Autowired
    private ResultService resultService;

    // 설문지 보내기(조회요청)
    @GetMapping("/question")
    public List<SurveyResponseDto> sendServey() {
        return serveyService.sendSurvey();
    }
<<<<<<< HEAD
=======

    @PostMapping("/question")
    public void receiveAnswersAndCookie(@RequestBody AnswersRequest answersRequest, HttpServletRequest request) throws BadRequestException {
        // 쿠키 출력
        Cookie[] cookies = request.getCookies();
        String uuid = cookies[0].getValue();

        // 받은 answers 배열 출력
        int[] test =  Arrays.stream(answersRequest.getAnswers()).mapToInt(Integer::parseInt).toArray();
        ResultRequestDto resultRequestDto = new ResultRequestDto(test);

        resultService.CalulateMBTI(resultRequestDto, uuid);
    }
>>>>>>> b24d98226c2c491786038199a3d058d8eb3bda91
}