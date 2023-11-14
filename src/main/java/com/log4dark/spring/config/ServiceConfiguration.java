package com.log4dark.spring.config;

import com.log4dark.spring.service.InventoryService;
import com.log4dark.spring.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * - @Configuration
 *   L 각 빈을 스프링 애플리케이션 컨텍스트(컨테이너)에 제공하는 구성 클래스라는 것을 알려준다.
 * - @Bean
 *   L 각 메서드에서 반환되는 객체가 애플리케이션 컨텍스트의 빈으로 추가되어야 한다는 것을 나타낸다.
 *   L 각 빈의 ID가 해당 빈을 정의하는 메서드의 이름과 동일.
 */
@Configuration
public class ServiceConfiguration {
    @Bean
    public InventoryService inventoryService() {
        return new InventoryService();
    }
    @Bean
    public ProductService productService() {
        return new ProductService(inventoryService());
    }
}
