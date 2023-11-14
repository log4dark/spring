package com.log4dark.spring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * - @WebMvcTest: 스프링 MVC 애플리케이션 형태로 테스트가 실행 되도록 한다.
 *   L 즉, HomeController가 스프링 MVC에 등록되므로 우리가 스프링 MVC에 웹 요청을 보낼 수 있다.
 */
@WebMvcTest(HomeController.class) // HomeController의 웹 페이지 테스트
class HomeControllerTest {

    // - 실제 서버 시작 대신 스프링 MVC의 모의(mocking) 매커니즘 사용
    // - MockMvc 객체로 '/'의 HTTP GET 요청을 수행
    @Autowired
    private MockMvc mockMvc; // MockMvc를 주입.

    @Test
    void home() throws Exception {
        mockMvc.perform(get("/")) // GET '/'를 수행한다
                .andExpect(status().isOk()) // HTTP 200이 되어야 한다
                .andExpect(view().name("home")) // home 뷰가 있어야 한다
                .andExpect(content().string( // 콘텐츠에 'Welcome to...'가 포함되어야 한다
                        containsString("Welcome to...")
                ));
    }
}