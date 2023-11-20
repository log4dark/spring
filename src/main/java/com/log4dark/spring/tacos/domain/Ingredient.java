package com.log4dark.spring.tacos.domain;

import lombok.Data;

/* @Data
 - @RequiredArgsConstructor // final 속성들을 초기화화 하는 생성자
   L 빈 주입 시, 생성자 직접 생성하지 않고 @RequiredArgsConstructor 설정 시, 바로 주입 됨.
 - @Getter, @Setter
 - @EqualsAndHashCode // equals(), hashCode()
 - @ToString // toString()
 */
@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Ingredient.Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
