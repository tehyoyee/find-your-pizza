package com.pizzaTest.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // 허용할 Origin 설정
        config.addAllowedOrigin("http://localhost:3000");
        // 허용할 Method 설정
        config.addAllowedMethod("*"); // 모든 HTTP 메소드 허용
        // 허용할 Header 설정
        config.addAllowedHeader("*"); // 모든 헤더 허용
        // Credentials 허용
        // 이 설정은 요청이 인증 정보를 포함하는 경우에 해당. 즉, 클라이언트가 요청을 보낼 때 요청에 인증 토큰이나 쿠키 등의 인증 정보를 함께 보내는 경우를 의미
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
