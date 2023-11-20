package com.log4dark.spring.tacos.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Taco {

    @NotNull // 값이 없거나 null인지 확인
    @Size(min=5, message="Name must be at least 5 characters long") // 다섯 문자 이상 입력
    private String name;

    @Size(min=1, message="You must choose at least 1 ingredient") // 최소한 하나 이상의 식자재 항목을 선택했는지 확인
    private List<String> ingredients;
}
