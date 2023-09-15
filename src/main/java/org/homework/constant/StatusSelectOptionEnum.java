package org.homework.constant;

import java.util.Arrays;

public enum StatusSelectOptionEnum {

    TODO("1"), DOING("2"), DONE("3");

    private final String input;
    StatusSelectOptionEnum(String input) {
        this.input = input;
    }


    public static StatusSelectOptionEnum of(String input) {
        return Arrays.stream(StatusSelectOptionEnum.values())
                .filter(value -> value.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("잘못된 입력입니다."));
    }
}
