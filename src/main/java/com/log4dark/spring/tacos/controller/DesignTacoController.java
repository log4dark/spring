package com.log4dark.spring.tacos.controller;

import com.log4dark.spring.tacos.domain.Ingredient;
import com.log4dark.spring.tacos.domain.Ingredient.Type;
import com.log4dark.spring.tacos.domain.Taco;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 2023.11.20 [dark]
 - @Slf4j 애노테이션은 다음 코드를 추가한 것과 같은 효과
    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
 - @Controller 애노테이션은 컴포넌트 검색을 해야한다는 것을 나타냄
   L 스프링이 DesignTacoController 클래스를 찾은 후 스프링 애플리케이션 컨텍스트의 빈(bean)으로
   L 이 클래스의 인스턴스를 자동 생성.
 */
@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    /*
    2023.11.20 [dark]
    - Model은 컨트롤러와 데이터를 보여주는 뷰 사이에서 데이터를 운반하는 객체
      L Model 객체의 속성에 있는 데이터는 뷰가 알 수 있는 서블릿(servlet) 요청 속성들로 복사된다.
     */
    @GetMapping
    public String showDesignForm(Model model) {

        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        for (Ingredient ingredient : ingredients) {
            log.info("ingredient: {}", ingredient);
        }

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            log.info("type.toString().toLowerCase(): {}", type.toString().toLowerCase());
            model.addAttribute(/*attributeName:*/type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        model.addAttribute("taco", new Taco());

        return "/design"; // 모델 데이터를 브라우저에 나타내는 데 사용될 뷰의 논리적인 이름 - /templates/design.html 호출
    }

    /*
    TODO: 2023.11.21 [dark]
    - 식자재의 유형(고기, 치즈, 소스 등)을 List에서 필터링?
     */
    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    /*
    2023.11.20 [dark] - @Valid 적용을 위해서 "spring-boot-starter-validation" dependency 추가
     */
    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors) {
        if (errors.hasErrors()) {
            log.warn("processDesign invalid param: {}", errors);
            return "design";
        }

        // 이 지점에서 타코 디자인(선택된 식자재 내역)을 저장한다…
        // 이 작업은 3장에서 할 것이다.
        log.info("Processing design: " + design);

        return "redirect:/orders/current";
    }
}
