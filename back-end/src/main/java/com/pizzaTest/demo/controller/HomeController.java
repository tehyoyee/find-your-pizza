<<<<<<< HEAD
package com.pizzaTest.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
=======
//package com.pizzaTest.demo.controller;
//
//import com.pizzaTest.demo.dto.UuidResponseDto;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HomeController {
//
//    @GetMapping("/uuid")
//    public UuidResponseDto createMember() {
//        return
//    }
//
//
//}
>>>>>>> 7d39abeaca2303565317fc99db785cb459ef13b3
