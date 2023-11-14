package com.log4dark.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * - @Controller: 컴포넌트 검색 시 HomeController 클래스가 컴포넌트(빈)로 식별되게 하는 것이 주 목적
 *   L 스프링 컴포넌트 검색에서는 자동으로 HomeController 클래스를 찾은 후,
 *   L '스프링 애플리케이션 컨텍스트'의 '빈'으로 HomeController의 인스턴스를 생성
 */
@Slf4j
@Controller // 컴포넌트 검색 시 HomeController 클래스가 컴포넌트(빈)로 식별되게 하는 것이 주 목적
public class HomeController {

    @GetMapping("/")
    public String home() {
        log.info("home() - start...");
        return "home"; // 뷰 이름을 반환한다. (이 값은 뷰의 논리적인 이름)
        /*
        논리적인 뷰 이름(home) 앞에 /templates/가 붙고 끝에는 .html이 추가된 것이 템플릿 경로와 파일이름 되므로
        여기서는 /templates/home.html이 된다.
         */
    }
}
