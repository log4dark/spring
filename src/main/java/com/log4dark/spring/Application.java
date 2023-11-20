package com.log4dark.spring;

import com.log4dark.spring.service.bean.ProductService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * - 스프링은 '스프링 애플리케이션 컨텍스트'(Spring application context)라는 '컨테이너'(container) 제공.
 * - '컨테이너' 에서 애플리케이션 컴포넌트에서 의존(사용)하는 다른 '빈'의 생성과 관리를 하고 해당 컴포넌트를 필요로 하는 '빈'에 '주입'(연결) 한다.
 * - '빈'의 상호 연결은 '의존성 주입'(Dependency Injection, DI)이라고 알려진 패턴을 기반으로 수행
 */
@Slf4j
@SpringBootApplication // 스프링 부트 애플리케이션
// - @SpringBootConfiguration: 현재 클래스를 구성(configuration) 클래스로 지정
// - @EnableAutoConfiguration: 스프링 부트 자동-구성(autoconfiguration) 활성화 -> 컨테이너에 빈 주입 역할?
// - @ComponentScan: 컴포넌트 검색 활성화
//   L @Component, @Controller, @Service 클래스 찾아서 스프링 애플리케이션 컨텍스트(컨테이너)에 컴포넌트(빈) 등록
public class Application implements ApplicationRunner { // 요넘이 부트스트랩(구동) 클래스
//public class Application {

    @Resource
    private ProductService productService;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 애플리케이션을 실행한다

        log.info("Hello Dark!");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Run dark ...");

        productService.display();

        // - Timestamp: 2023-11-03 02:29:17.123
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        // - Timestamp to String formatting: 2023-11-03T02:29:17.123
        String createdAt2String = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").format(createdAt);

        log.info("createdAt2String: {} ", createdAt2String);


        log.info("Stop dark ...");
    }

}
